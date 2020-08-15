package org.freud.message.client;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/***
 * 通过消息队列向单个用户发送消息
 */
public interface MessageStreamSource {
    String TO_USER = "messageToUserOutput";
    String TO_GROUP = "messageToGroupOutput";

    @Output(TO_USER)
    MessageChannel sendMessageToUserOutput();

    @Output(TO_GROUP)
    MessageChannel sendMessageToGroupOutput();
}
