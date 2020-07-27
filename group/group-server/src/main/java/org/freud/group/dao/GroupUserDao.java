package org.freud.group.dao;

import lombok.Getter;
import org.freud.group.dao.repository.GroupUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class GroupUserDao {
    @Autowired
    private GroupUserRepository repository;
}
