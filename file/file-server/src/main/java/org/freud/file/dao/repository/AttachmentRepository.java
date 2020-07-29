package org.freud.file.dao.repository;

import org.freud.file.entity.Attachment;
import org.springframework.data.repository.CrudRepository;

public interface AttachmentRepository extends CrudRepository<Attachment, Integer> {
}
