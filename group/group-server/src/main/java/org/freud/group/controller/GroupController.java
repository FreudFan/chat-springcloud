package org.freud.group.controller;

import org.freud.group.entity.Group;
import org.freud.group.entity.Notice;
import org.freud.group.enums.OperatorGroupRequestTypeEnum;
import org.freud.group.enums.RequestGroupStatusEnum;
import org.freud.group.exception.FormException;
import org.freud.group.exception.GroupException;
import org.freud.group.service.GroupAttachmentService;
import org.freud.group.service.GroupNoticeService;
import org.freud.group.service.GroupService;
import org.freud.group.common.AcceptGroupVO;
import org.freud.group.common.GroupAttachmentVO;
import org.freud.group.common.GroupRequestVO;
import org.freud.group.common.GroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private GroupAttachmentService groupAttachmentService;
    @Autowired
    private GroupNoticeService groupNoticeService;

    /***
     * 创建用户群
     * @param group
     * @return
     */
    @PostMapping("/create")
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    /***
     * 发送申请加群请求
     * @param groupId
     * @return
     */
    @PostMapping("/requestGroup/{groupId}")
    public ResponseEntity<String> addGroupRequest(@PathVariable("groupId") Integer groupId) {
        RequestGroupStatusEnum statusEnum = groupService.requestGroup(groupId);
        if (statusEnum == RequestGroupStatusEnum.SUCCESS) {
            return new ResponseEntity<>(statusEnum.name, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(statusEnum.name, HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * 处理群申请请求
     * @param acceptGroupVO
     * @return
     */
    @PostMapping("/acceptGroup")
    public boolean processGroupRequest(@RequestBody AcceptGroupVO acceptGroupVO) {
        int operationType = acceptGroupVO.getOperationType();
        if (groupService.getGroupInfo(acceptGroupVO.getSendGroupId()) == null) {
            throw new FormException("没有该群号");
        } else if (!userDao.getRepository().findById(acceptGroupVO.getSendUserId()).isPresent()) {
            throw new FormException("没有该用户");
        }
        if (operationType == OperatorGroupRequestTypeEnum.PASS.value) {
            groupService.agreeGroupRequest(acceptGroupVO.getSendGroupId(), acceptGroupVO.getSendUserId());
            return true;
        } else if (operationType == OperatorGroupRequestTypeEnum.IGNORE.value) {
            groupService.ignoreGroupRequest(acceptGroupVO.getSendGroupId(), acceptGroupVO.getSendUserId());
            return false;
        } else {
            throw new FormException("操作代码错误");
        }
    }

    /***
     * 解散群 假删除
     * @param groupId
     * @throws "群不存在"
     * @throws "用户无权限，只有群主可以解散群哦~"
     */
    @PostMapping("/dissolute/{groupId}")
    public void disbandGroup(@PathVariable("groupId") Integer groupId) {
        groupService.disbandGroup(groupId);
    }

    /***
     * 查询群成员列表
     * @param groupId
     * @return
     */
    @GetMapping("/members/{groupId}")
    public List<UserVO> queryGroupList(@PathVariable("groupId") Integer groupId) {
        return groupService.queryGroupUsers(groupId);
    }

    /***
     * 搜索群名称
     * @param name 模糊搜索 群名称
     * @return
     */
    @GetMapping("/queryGroup/{name}")
    public List<GroupVO> queryGroup(@PathVariable("name") String name) {
        List<GroupVO> groups = groupService.searchGroup(name);
        return groups;
    }

    /***
     * 查看当前用户的群权限
     * @return int
     */
    @GetMapping("/queryUserRole/{groupId}")
    public int queryUserRole(@PathVariable("groupId") Integer groupId) {
        return groupService.getGroupUserRole(groupId);
    }

    /***
     * 查看群资料
     * @return
     */
    @GetMapping("/infoGroup/{groupId}")
    public Group getGroupInfo(@PathVariable("groupId") Integer groupId) {
        return groupService.getGroupInfo(groupId);
    }

    /***
     * 编辑群资料
     * @param group
     * @return
     */
    @PostMapping("/changeGroupInfo")
    public Group changeGroupInfo(@RequestBody Group group) {
        return groupService.changeGroupInfo(group);
    }

    /***
     * 上传群文件
     * @param file
     * @return
     */
    @PostMapping("/uploadGroupAttachment/{groupId}")
    public ResponseEntity<Integer> upLoadGroupAttachment(@RequestParam("file") MultipartFile file,
                                                         @PathVariable("groupId") Integer groupId) {
        if (file == null) {
            throw new GroupException("上传文件失败，文件为空 !");
        }
        int groupAttachmentId = groupAttachmentService.uploadGroupAttachment(groupId, file);
        return new ResponseEntity<>(groupAttachmentId, HttpStatus.OK);
    }

    /***
     * 展示群文件列表
     * @param groupId
     * @return
     */
    @GetMapping("/showGroupAttachmentList/{groupId}")
    public List<GroupAttachmentVO> showGroupAttachments(@PathVariable("groupId") Integer groupId) {
        return groupAttachmentService.showGroupAttachmentList(groupId);
    }

    /***
     * 删除群文件
     * @param groupId，fileId
     * @return
     */
    @PostMapping("/deleteGroupAttachment/{groupId}/{fileId}")
    public boolean showGroupAttachments(@PathVariable("groupId") Integer groupId, @PathVariable("fileId") String fileId) {
        return groupAttachmentService.deleteGroupAttachment(groupId, fileId);
    }

    /***
     * 群主设置管理员权限
     * @param groupId,userId
     * @return
     */
    @PostMapping("/setUserManageRole/{groupId}/{userId}")
    public boolean setUserManageRole(@PathVariable("groupId") Integer groupId, @PathVariable("userId") Integer userId) {
        return groupService.setGroupUserManageRole(groupId, userId);
    }

    /***
     * 群主移除用户的管理员权限
     * @param groupId,userId
     * @return
     */
    @PostMapping("/removeGroupUser/{groupId}/{userId}")
    public boolean removeGroupUser(@PathVariable("groupId") Integer groupId, @PathVariable("userId") Integer userId) {
        return groupService.removeGroupUser(groupId, userId);
    }

    /***
     * 移除群用户功能（群主能移除所有用户，管理员只能移除普通用户）
     * @param groupId,userIdId
     * @return
     */
    @PostMapping("/removeUserManageRole/{groupId}/{userId}")
    public boolean removeUserManageRole(@PathVariable("groupId") Integer groupId, @PathVariable("userId") Integer userId) {
        return groupService.removeGroupUserManageRole(groupId, userId);
    }

    /***
     * 显示群用户信息（如果查询的该用户是自己的好友的话，额外显示该用户的备注）
     * @param groupId,userId
     * @return
     */
    @GetMapping("/showGroupUserInfo/{groupId}/{userId}")
    public UserVO showGroupUserInfo(@PathVariable("groupId") Integer groupId, @PathVariable("userId") Integer userId) {
        return groupService.showGroupUserInfo(groupId, userId);
    }

    /***
     * 增加群公告（只有群主和管理员能添加）
     * @param notice
     * @return
     */
    @PostMapping("/addNotice")
    public boolean addNotice(@RequestBody Notice notice) {
        return groupNoticeService.addNotice(notice);
    }

    /***
     * 删除群公告（只有群主和管理员能删除）
     * @param groupId,noticeId
     * @return
     */
    @PostMapping("/deleteNotice/{groupId}/{noticeId}")
    public boolean deleteNotice(@PathVariable("groupId") Integer groupId, @PathVariable("noticeId") Integer noticeId) {
        return groupNoticeService.deleteNotice(groupId, noticeId);
    }

    /***
     * 修改群公告（只有群主和管理员能修改）
     * @param notice
     * @return
     */
    @PostMapping("/updateNotice")
    public boolean updateNotice(@RequestBody Notice notice) {
        return groupNoticeService.updateNotice(notice);
    }

    /***
     * 显示单个群公告
     * @param noticeId
     * @return
     */
    @GetMapping("/showNotice/{noticeId}")
    public Notice showNotice(@PathVariable("noticeId") Integer noticeId) {
        return groupNoticeService.showNotice(noticeId);
    }

    /***
     * 显示群公告列表
     * @param groupId
     * @return
     */
    @GetMapping("/showNoticeList/{groupId}")
    public List<Notice> showNoticeList(@PathVariable("groupId") Integer groupId) {
        return groupNoticeService.showNoticeList(groupId);
    }

    /***
     * 查询好友通知
     * @return
     */
    @Override
    @GetMapping("/searchGroupRequest/{groupId}")
    public List<GroupRequestVO> searchGroupRequest(@PathVariable("groupId") Integer groupId) {
        return groupService.listGroupRequest(groupId);
    }

    /***
     * 获取用户群内昵称
     * @param groupId
     * @return
     */
    @GetMapping("/nickname/{groupId}")
    public String getNickname(@PathVariable("groupId") Integer groupId) {
        int userId = RequestContent.getCurrentUser().getId();
        return groupService.getUserGroupNickname(groupId, userId);
    }

    /***
     * 修改用户群昵称
     * @param groupId
     * @param nickName
     * @return
     */
    @PostMapping("/nickname/{groupId}/{nickName}")
    public boolean changeNickname(@PathVariable("groupId") Integer groupId, @PathVariable("nickName") String nickName) {
        int userId = RequestContent.getCurrentUser().getId();
        return groupService.changeUserGroupNickname(groupId, userId, nickName);
    }

}
