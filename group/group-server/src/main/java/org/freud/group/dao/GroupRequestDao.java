package org.freud.group.dao;

import lombok.Getter;
import org.freud.group.dao.mapper.GroupRequestMapper;
import org.freud.group.dao.repository.GroupRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class GroupRequestDao {
    @Autowired
    private GroupRequestRepository repository;
    @Autowired
    private GroupRequestMapper mapper;
}
