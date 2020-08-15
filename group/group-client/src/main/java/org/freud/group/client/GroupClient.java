package org.freud.group.client;

import org.freud.group.common.GroupDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "group")
public interface GroupClient {

    /***
     * 查询用户加入的群
     * @param userId
     * @return
     */
    @GetMapping("/service/queryUserGroups/{userId}")
    List<GroupDTO> queryUserGroups(@PathVariable("userId") Integer userId);

    /***
     * 查找群用户id
     * @param groupId
     * @return
     */
    @GetMapping("/service/getGroupUsersId/{groupId}")
    List<Integer> getGroupUsersId(@PathVariable("groupId") Integer groupId);

    /***
     * 获取用户在群内昵称
     * @param groupId
     * @param userId
     * @return
     */
    @GetMapping("/service/getUserGroupNickname/{groupId}/{userId}")
    String getUserGroupNickname(@PathVariable("groupId") Integer groupId, @PathVariable("userId") Integer userId);

}
