package org.freud.user.dao;

import lombok.Getter;
import org.freud.user.dao.repository.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class FriendRequestDao {
    @Autowired
    private FriendRequestRepository repository;
}
