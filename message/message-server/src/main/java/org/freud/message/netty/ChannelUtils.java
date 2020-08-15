package org.freud.message.netty;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;
import org.freud.group.client.GroupClient;
import org.freud.message.common.DataContent;
import org.freud.message.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("channelUtils")
public class ChannelUtils {
    @Autowired
    private GroupClient groupClient;

    /***
     * 向单个用户发送通知
     * @param dataContent 消息内容
     */
    public void sendMessageToUser(DataContent dataContent) {
        try {
            // 目标用户 id
            Integer targetId = dataContent.getChatMsg().getReceiverId();
            Channel receiverChannel = UserChannelRel.get(targetId);
            if (receiverChannel == null) {
                // 用户离线消息
                this.sendOfflineMessage();
            } else {
                Channel findChannel = ChatHandler.users.find(receiverChannel.id());
                if (findChannel != null) {
                    receiverChannel.writeAndFlush(new TextWebSocketFrame(JacksonUtil.toJSON(dataContent)));
                } else {
                    // 用户离线消息
                    this.sendOfflineMessage();
                }
            }
        } catch (Exception e) {
            log.error("发送消息失败! {}", dataContent);
        }
    }

    /***
     * 广播群通知
     * @param dataContent
     */
    public void sendMessageToGroupUser(DataContent dataContent) {
        try {
            // 目标群 id
            Integer groupId = dataContent.getChatMsg().getGroupId();
            List<Integer> userIds = groupClient.getGroupUsersId(groupId);
            ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
            userIds.forEach(id -> {
                Channel channel = UserChannelRel.get(id);
                if (channel != null) {
                    group.add(channel);
                }
            });
            group.writeAndFlush(new TextWebSocketFrame(JacksonUtil.toJSON(dataContent)));
        } catch (Exception e) {
            log.error("发送群消息失败! {}", dataContent);
        }
    }

    /***
     * 发送离线消息
     */
    public void sendOfflineMessage() {

    }

}
