package org.freud.group.dao.repository;

import org.freud.group.entity.GroupRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRequestRepository extends CrudRepository<GroupRequest, Integer> {

    GroupRequest findBySendUserIdAndGroupId(Integer sendId, Integer acceptId);

    List<GroupRequest> findAllByGroupId(Integer groupId);

    void deleteByGroupIdAndAndSendUserId(Integer groupId, Integer userId);
}
