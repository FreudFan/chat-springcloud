package org.freud.group.dao.repository;

import org.freud.group.entity.GroupUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupUserRepository extends CrudRepository<GroupUser, Integer> {

    void deleteByGroupIdAndUserId(Integer groupId, Integer userId);

    List<GroupUser> findAllByUserId(Integer userId);

    GroupUser findByGroupIdAndUserId(Integer groupId, Integer userId);

}
