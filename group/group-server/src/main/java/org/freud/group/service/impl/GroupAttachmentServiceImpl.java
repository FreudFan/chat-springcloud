package org.freud.group.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.freud.group.common.GroupAttachmentVO;
import org.freud.group.dao.GroupAttachmentDao;
import org.freud.group.dao.GroupUserDao;
import org.freud.group.entity.GroupAttachment;
import org.freud.group.entity.GroupUser;
import org.freud.group.enums.GroupRoleEnum;
import org.freud.group.service.GroupAttachmentService;
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
    //TODO 暂时
//    @Autowired
//    private AttachmentService attachmentService;
    @Autowired
    private GroupUserDao groupuserDao;

    //TODO 暂时
//    @Override
//    public Integer uploadGroupAttachment(Integer groupId, MultipartFile file) {
//        GroupAttachment groupAttachment = new GroupAttachment();
//        try {
//            String fileId = attachmentService.saveAttachment(file);
//            groupAttachment.setFileId(fileId);
//            groupAttachment.setGroupId(groupId);
//            groupAttachmentDao.getRepository().save(groupAttachment);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return groupAttachment.getId();
//    }

    //TODO 暂时
//    @Override
//    public List<GroupAttachmentVO> showGroupAttachmentList(Integer groupId) {
//        List<GroupAttachmentVO> groupAttachmentVOS = new ArrayList<>();
//        List<GroupAttachment> groupAttachments = groupAttachmentDao.getMapper().findGroupAttachmentByGroupId(groupId);
//        for (GroupAttachment groupAttachment : groupAttachments) {
//            GroupAttachmentVO groupAttachmentVO = new GroupAttachmentVO();
//            Attachment attachment = attachmentService.getAttachmentInfo(groupAttachment.getFileId());
//            groupAttachmentVO.setContentSize(attachment.getContentSize());
//            groupAttachmentVO.setFileName(attachment.getName());
//            groupAttachmentVO.setFileId(groupAttachment.getFileId());
//            Optional<GroupUser> user = groupuserDao.getRepository().findById(attachment.getOwnerId());
//            UserVO userVO = new UserVO();
//            userVO.setId(user.get().getUserId());
//            userVO.setNickname(user.get().getNickname());
//            groupAttachmentVO.setUserVO(userVO);
//            groupAttachmentVOS.add(groupAttachmentVO);
//        }
//        return groupAttachmentVOS;
//    }

    //TODO 暂时
//    @Override
//    public boolean deleteGroupAttachment(Integer groupId, String fileId) {
//        int currentId = RequestContent.getCurrentUser().getId();
//        GroupUser groupUser = groupuserDao.getRepository().findByGroupIdAndUserId(groupId, currentId);
//        if (groupUser.getRoleId().equals(GroupRoleEnum.MEMBER.value))
//            return false;
//        groupAttachmentDao.getRepository().deleteByGroupIdAndFileId(groupId, fileId);
//        attachmentService.deleteAttachment(fileId);
//        return true;
//    }
}
