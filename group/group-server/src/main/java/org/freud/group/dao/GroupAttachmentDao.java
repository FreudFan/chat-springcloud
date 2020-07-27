package org.freud.group.dao;

import lombok.Getter;
import org.freud.group.dao.mapper.GroupAttachmentMapper;
import org.freud.group.dao.repository.GroupAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class GroupAttachmentDao {
    @Autowired
    private GroupAttachmentRepository repository;
    @Autowired
    private GroupAttachmentMapper mapper;

}
