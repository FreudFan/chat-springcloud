package org.freud.user.controller;

import org.freud.user.common.UserVO;
import org.freud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserVOInfo/{userId}")
    public UserVO getUserVOInfo(@PathVariable("userId") Integer userId) {
        return userService.getUserVOInfo(userId);
    }
}
