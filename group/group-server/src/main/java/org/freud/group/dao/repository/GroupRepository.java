package org.freud.group.dao.repository;

import org.freud.group.entity.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Integer> {

    List<Group> findAllById(Integer groupId);

}
