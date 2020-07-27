package org.freud.group.dao.repository;

import org.freud.group.entity.GroupAttachment;
import org.springframework.data.repository.CrudRepository;

public interface GroupAttachmentRepository extends CrudRepository<GroupAttachment, Integer> {

    void deleteByGroupIdAndFileId(Integer groupId, String fileId);
}
