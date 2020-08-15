package org.freud.message.client;

import lombok.extern.slf4j.Slf4j;
import org.freud.message.common.DataContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageStreamProducer {
    @Autowired
    private MessageStreamSource messageStreamSource;

    /***
     * 通过消息队列向单个用户发送消息
     * @param dataContent
     */
    public void sendMessageToUser(DataContent dataContent) {
        log.info("向topic【{}】发送消息消息: {}", "messageToUser", dataContent.toString());
        messageStreamSource.sendMessageToUserOutput().send(MessageBuilder.withPayload(dataContent).build());
    }

    /***
     * 通过消息队列向群组发送消息
     * @param dataContent
     */
    public void sendMessageToGroupOutput(DataContent dataContent) {
        log.info("向topic【{}】发送消息消息: {}", "messageToGroup", dataContent.toString());
        messageStreamSource.sendMessageToGroupOutput().send(MessageBuilder.withPayload(dataContent).build());
    }

}
