package org.freud.group.controller;

import org.freud.file.client.mq.FileStreamProducer;
import org.freud.user.client.UserClient;
import org.freud.user.common.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group/test")
public class TestController {

    @Autowired
    private FileStreamProducer fileStreamProducer;

    @GetMapping
    public void testMq() {
        fileStreamProducer.deleteAttachment("-1");
    }

    @Autowired
    private UserClient userClient;

    @GetMapping("/userClient")
    public void testuserclient() {
        UserVO userVO = userClient.getUserVOInfo(2);
        System.out.println(userVO);
    }
}
