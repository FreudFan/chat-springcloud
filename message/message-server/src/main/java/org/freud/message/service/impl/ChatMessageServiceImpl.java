package org.freud.message.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.freud.message.common.ChatMsg;
import org.freud.message.dao.ChatMessageDao;
import org.freud.message.entity.ChatMessage;
import org.freud.message.enums.MsgSignFlagEnum;
import org.freud.message.interceptor.RequestContent;
import org.freud.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service("chatMessageService")
public class ChatMessageServiceImpl implements MessageService {
    @Autowired
    private ChatMessageDao chatMessageDao;

    @Override
    public Integer saveMessage(ChatMsg chatMsg) {
        ChatMessage message = new ChatMessage();
        message.setSenderUserId(chatMsg.getSenderId());
        message.setAcceptUserId(chatMsg.getReceiverId());
        message.setMessage(chatMsg.getMsg());
        message.setSignFlag(MsgSignFlagEnum.UNSIGNED.type);
        return chatMessageDao.getRepository().save(message).getId();
    }

    @Override
    public void updateMsgSigned(List<Integer> msgIdList) {
        chatMessageDao.getMapper().batchUpdateMsgSigned(msgIdList);
    }

    @Override
    public List<ChatMsg> getUnReadMsgList(Integer acceptUserId) {
        return chatMessageDao.getMapper().getUnReadMessage(acceptUserId);
    }

    @Override
    public PageInfo<ChatMessage> getHistoryChatMessage(Integer userId, Integer pageNum, Integer size, LocalDate startDate) {
        if (size == null) {
            size = 20;
        }
        Integer currentId = RequestContent.getCurrentUser().getId();
        PageHelper.startPage(pageNum, size);
        List<ChatMessage> chatMessages = chatMessageDao.getMapper().getHistoryMessage(currentId, userId, startDate);
        return new PageInfo<>(chatMessages);
    }

}
