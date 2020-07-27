package org.freud.user.dao.repository;

import org.freud.user.entity.Friend;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendRepository extends CrudRepository<Friend, Integer> {

    List<Friend> findAllByUserId(Integer userId);

    Friend findByUserIdAndFriendId(Integer userId, Integer friendId);
}
