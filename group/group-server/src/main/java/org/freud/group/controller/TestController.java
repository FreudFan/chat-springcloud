package org.freud.group.controller;

import org.freud.file.client.mq.FileStreamProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private FileStreamProducer fileStreamProducer;

    @GetMapping
    public void testMq() {
        fileStreamProducer.deleteAttachment("-1");
    }
}
