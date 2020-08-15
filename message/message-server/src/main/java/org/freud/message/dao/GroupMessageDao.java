package org.freud.message.dao;

import lombok.Getter;
import org.freud.message.dao.mapper.GroupMessageMapper;
import org.freud.message.dao.repository.GroupMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class GroupMessageDao {
    @Autowired
    private GroupMessageRepository repository;
    @Autowired
    private GroupMessageMapper mapper;
}
