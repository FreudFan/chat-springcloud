package org.freud.group.dao;

import lombok.Getter;
import org.freud.group.dao.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class NoticeDao {
    @Autowired
    private NoticeRepository repository;

}
