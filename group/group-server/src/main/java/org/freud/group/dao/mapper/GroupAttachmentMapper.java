package org.freud.group.dao.mapper;

import org.freud.group.entity.GroupAttachment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupAttachmentMapper {

    List<GroupAttachment> findGroupAttachmentByGroupId(Integer groupId);

}
