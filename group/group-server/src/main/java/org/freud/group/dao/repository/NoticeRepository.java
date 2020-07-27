package org.freud.group.dao.repository;


import org.freud.group.entity.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeRepository extends CrudRepository<Notice, Integer> {

    void deleteByGroupIdAndId(Integer groupId, Integer noticeId);

    List<Notice> findAllByGroupId(Integer groupId);

}
