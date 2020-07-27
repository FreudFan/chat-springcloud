package org.freud.user.dao.repository;

import org.freud.user.entity.FriendGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FriendGroupRepository extends CrudRepository<FriendGroup, Integer> {

    /***
     * 根据用户id查询分组名称
     * @param userId
     * @return
     */
    List<FriendGroup> findAllByUserId(Integer userId);
}
