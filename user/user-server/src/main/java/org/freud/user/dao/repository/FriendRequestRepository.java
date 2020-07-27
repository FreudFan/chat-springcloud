package org.freud.user.dao.repository;

import org.freud.user.entity.FriendRequest;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

public interface FriendRequestRepository extends CrudRepository<FriendRequest, Id> {

    FriendRequest findBySendUserIdAndAcceptUserId(Integer sendId, Integer acceptId);

    void deleteBySendUserIdAndAcceptUserId(Integer sendId, Integer acceptId);
}
