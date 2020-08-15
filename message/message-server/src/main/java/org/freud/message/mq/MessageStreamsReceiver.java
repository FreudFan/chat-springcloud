package org.freud.message.mq;

import lombok.extern.slf4j.Slf4j;
import org.freud.message.common.DataContent;
import org.freud.message.netty.ChannelUtils;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class MessageStreamsReceiver {

    @Resource(name = "channelUtils")
    private ChannelUtils channelUtils;

    @StreamListener(MessageStreamSink.TO_USER)
    public void handleMessageToUser(@Payload DataContent dataContent) {
        log.info("从topic【{}】接收到消息: {}    开始向用户发送消息", "messageToUser", dataContent);
        channelUtils.sendMessageToUser(dataContent);
    }

    @StreamListener(MessageStreamSink.TO_GROUP)
    public void handleMessageToGroup(@Payload DataContent dataContent) {
        log.info("从topic【{}】接收到消息: {}    开始发送群消息", "messageToGroup", dataContent);
        channelUtils.sendMessageToGroupUser(dataContent);
    }
}
