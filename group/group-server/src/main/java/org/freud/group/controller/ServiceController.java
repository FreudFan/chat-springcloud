package org.freud.group.controller;

import org.freud.group.common.GroupDTO;
import org.freud.group.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * 微服务RPC service
 */
@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private GroupService groupService;

    /***
     * 查询用户加入的群
     * @param userId
     * @return
     */
    @GetMapping("/queryUserGroups/{userId}")
    public List<GroupDTO> queryUserGroups(@PathVariable("userId") Integer userId) {
        return groupService.queryUserGroups(userId);
    }

    /***
     * 查找群用户id
     * @param groupId
     * @return
     */
    @GetMapping("/getGroupUsersId/{groupId}")
    public List<Integer> getGroupUsersId(@PathVariable("groupId") Integer groupId) {
        return groupService.getGroupUsersId(groupId);
    }

    /***
     * 获取用户在群内昵称
     * @param groupId
     * @param userId
     * @return
     */
    @GetMapping("/getUserGroupNickname/{groupId}/{userId}")
    public String getUserGroupNickname(@PathVariable("groupId") Integer groupId, @PathVariable("userId") Integer userId) {
        return groupService.getUserGroupNickname(groupId, userId);
    }

}
