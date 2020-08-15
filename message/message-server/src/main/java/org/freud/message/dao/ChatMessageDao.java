package org.freud.message.dao;

import lombok.Getter;
import org.freud.message.dao.mapper.ChatMessageMapper;
import org.freud.message.dao.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class ChatMessageDao {
    @Autowired
    private ChatMessageRepository repository;
    @Autowired
    private ChatMessageMapper mapper;
}
