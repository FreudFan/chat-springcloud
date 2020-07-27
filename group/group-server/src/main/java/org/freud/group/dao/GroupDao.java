package org.freud.group.dao;

import lombok.Getter;
import org.freud.group.dao.mapper.GroupMapper;
import org.freud.group.dao.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class GroupDao {
    @Autowired
    private GroupRepository repository;
    @Autowired
    private GroupMapper mapper;
}
