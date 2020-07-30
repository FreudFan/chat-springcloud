package org.freud.file.client.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FileStreamProducer {
    @Autowired
    private FileStreamSource fileStreamSource;

    /***
     * 删除文件
     * 向topic传文件id，客户端会自动删除文件
     * @param fileId
     * @return
     */
    public void deleteAttachment(String fileId) {
        log.info("向topic【{}】发送消息消息: {}", "fileDelete", fileId);
        fileStreamSource.output().send(MessageBuilder.withPayload(fileId).build());
    }

}
