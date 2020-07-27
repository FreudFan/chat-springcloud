package org.freud.group.dao;

import lombok.Getter;
import org.freud.group.dao.mapper.GroupMessageMapper;
import org.freud.group.dao.repository.GroupMessageRepository;
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
