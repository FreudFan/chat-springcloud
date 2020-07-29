package org.freud.file.dao;

import lombok.Getter;
import org.freud.file.dao.mapper.AttachmentMapper;
import org.freud.file.dao.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class AttachmentDao {
    @Autowired
    private AttachmentRepository repository;
    @Autowired
    private AttachmentMapper mapper;
}
