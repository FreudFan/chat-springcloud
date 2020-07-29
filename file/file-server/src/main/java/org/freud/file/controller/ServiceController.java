package org.freud.file.controller;

import org.freud.file.common.AttachmentDTO;
import org.freud.file.entity.Attachment;
import org.freud.file.exception.AttachmentException;
import org.freud.file.interceptor.RequestContent;
import org.freud.file.service.AttachmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/***
 * 微服务RPC service
 */
@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private AttachmentService attachmentService;

    /***
     * 上传文件
     * @param file 文件
     * @param ownerId 文件拥有者 id
     * @return
     */
    @PostMapping(value = "/upLoadAttachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upLoadAttachment(@RequestPart("file") MultipartFile file,
                                   @RequestParam("ownerId") Integer ownerId) {
        if (file == null) {
            throw new AttachmentException("上传文件失败，文件为空 !");
        }
        String attachmentId = attachmentService.saveAttachment(file, ownerId);
        return attachmentId;
    }

    /***
     * 获取文件基本信息
     * @param fileId
     * @return
     */
    @GetMapping("/getAttachmentInfo")
    public AttachmentDTO getAttachmentInfo(@RequestParam("fileId") String fileId) {
        return attachmentService.getAttachmentInfo(fileId);
    }

    /***
     * 删除文件
     * @param fileId
     * @return
     */
    @PostMapping("/deleteAttachment")
    public Boolean deleteAttachment(@RequestParam("fileId") String fileId) {
        attachmentService.deleteAttachment(fileId);
        return true;
    }
}
