package org.freud.user.dao;

import lombok.Getter;
import org.freud.user.dao.mapper.UserMapper;
import org.freud.user.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class UserDao {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserRepository repository;
}
