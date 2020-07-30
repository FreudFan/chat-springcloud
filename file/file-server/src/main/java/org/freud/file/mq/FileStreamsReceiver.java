package org.freud.file.mq;

import lombok.extern.slf4j.Slf4j;
import org.freud.file.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileStreamsReceiver {

    @Autowired
    private AttachmentService attachmentService;

    @StreamListener(FileStreamSink.INPUT)
    public void handleGreetings(@Payload String fileId) {
        log.info("从topic【{}】接收到消息: {}    开始删除文件", "fileDelete", fileId);
        attachmentService.deleteAttachment(fileId);
    }

}
