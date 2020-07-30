package org.freud.group.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.freud.file.client.FileClient;
import org.freud.file.client.mq.FileStreamProducer;
import org.freud.file.common.AttachmentDTO;
import org.freud.group.common.GroupAttachmentVO;
import org.freud.group.dao.GroupAttachmentDao;
import org.freud.group.dao.GroupUserDao;
import org.freud.group.entity.GroupAttachment;
import org.freud.group.entity.GroupUser;
import org.freud.group.enums.GroupRoleEnum;
import org.freud.group.exception.GroupException;
import org.freud.group.interceptor.RequestContent;
import org.freud.group.service.GroupAttachmentService;
import org.freud.user.common.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class GroupAttachmentServiceImpl implements GroupAttachmentService {

    @Autowired
    private GroupAttachmentDao groupAttachmentDao;
    @Autowired
    private GroupUserDao groupUserDao;
    @Autowired
    private FileClient fileClient;
    @Autowired
    private FileStreamProducer fileStreamProducer;

    @Override
    public Integer uploadGroupAttachment(Integer groupId, MultipartFile file) {
        GroupAttachment groupAttachment = new GroupAttachment();

        Integer currentId = RequestContent.getCurrentUser().getId();
        GroupUser groupUser = groupUserDao.getRepository().findByGroupIdAndUserId(groupId, currentId);
        if (groupUser == null) {
            throw new GroupException("用户 [id:" + currentId + "] 不在群 [id:" + groupId + "] 内, 无法上传文件");
        }
        String fileId = fileClient.upLoadAttachment(file, currentId);
        groupAttachment.setFileId(fileId);
        groupAttachment.setGroupId(groupId);
        groupAttachmentDao.getRepository().save(groupAttachment);

        return groupAttachment.getId();
    }

    @Override
    public List<GroupAttachmentVO> showGroupAttachmentList(Integer groupId) {
        List<GroupAttachmentVO> groupAttachmentVOS = new ArrayList<>();
        List<GroupAttachment> groupAttachments = groupAttachmentDao.getMapper().findGroupAttachmentByGroupId(groupId);
        for (GroupAttachment groupAttachment : groupAttachments) {
            GroupAttachmentVO groupAttachmentVO = new GroupAttachmentVO();
            AttachmentDTO attachmentDTO = fileClient.getAttachmentInfo(groupAttachment.getFileId());
//            Attachment attachment = attachmentService.getAttachmentInfo(groupAttachment.getFileId());
            groupAttachmentVO.setContentSize(attachmentDTO.getContentSize());
            groupAttachmentVO.setFileName(attachmentDTO.getName());
            groupAttachmentVO.setFileId(groupAttachment.getFileId());

//            Optional<GroupUser> user = groupuserDao.getRepository().findById(attachmentDTO.getOwnerId());
//            UserVO userVO = new UserVO();
//            userVO.setId(user.get().getUserId());
//            userVO.setNickname(user.get().getNickname());

            GroupUser user = groupUserDao.getRepository().findByGroupIdAndUserId(groupId, attachmentDTO.getOwnerId());
            UserVO userVO = new UserVO();
            userVO.setId(user.getUserId());
            userVO.setNickname(user.getNickname());

            groupAttachmentVO.setUserVO(userVO);
            groupAttachmentVOS.add(groupAttachmentVO);
        }
        return groupAttachmentVOS;
    }

    @Override
    public boolean deleteGroupAttachment(Integer groupId, String fileId) {
        int currentId = RequestContent.getCurrentUser().getId();
        GroupUser groupUser = groupUserDao.getRepository().findByGroupIdAndUserId(groupId, currentId);
        if (groupUser.getRoleId().equals(GroupRoleEnum.MEMBER.value))
            return false;
        groupAttachmentDao.getRepository().deleteByGroupIdAndFileId(groupId, fileId);
        // 可以使用 rpc 调用文件服务删除文件，也可以通过消息队列通知文件服务删除文件
//        fileClient.deleteAttachment(fileId);
        fileStreamProducer.deleteAttachment(fileId);
        return true;
    }
}
