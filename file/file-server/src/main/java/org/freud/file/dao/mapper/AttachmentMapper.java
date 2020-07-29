package org.freud.file.dao.mapper;

import org.freud.file.entity.Attachment;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentMapper {

    Attachment getAttachmentById(String id);

    Attachment getAttachmentInfoById(String id);
}
