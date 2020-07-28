package org.freud.user.controller;

import org.freud.user.common.UserVO;
import org.freud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private UserService userService;

    /***
     * 查询用户基本信息
     * @param userId
     * @return
     */
    @GetMapping("/getUserVOInfo/{userId}")
    public UserVO getUserVOInfo(@PathVariable("userId") Integer userId) {
        return userService.getUserVOInfo(userId);
    }

    /***
     * 查询陌生人基本信息
     * 如果是好友 添加好友备注
     * @param userId
     * @return
     */
    @GetMapping("/getUserVOInfoWithFriendFlag")
    public UserVO getUserVOInfoWithFriendFlag(@RequestParam("userId") Integer userId,
                                              @RequestParam("currentId") Integer currentId) {
        return userService.getUserVOInfoWithFriendFlag(userId, currentId);
    }

}
