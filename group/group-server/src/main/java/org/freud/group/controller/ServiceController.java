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
    List<GroupDTO> queryUserGroups(@PathVariable("userId") Integer userId) {
        return groupService.queryUserGroups(userId);
    }

}
