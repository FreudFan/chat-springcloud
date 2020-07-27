package org.freud.user.dao;

import lombok.Getter;
import org.freud.user.dao.repository.FriendGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class FriendGroupDao {
    @Autowired
    private FriendGroupRepository repository;
}
