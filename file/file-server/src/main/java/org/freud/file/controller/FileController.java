package org.freud.file.controller;

import lombok.extern.slf4j.Slf4j;
import org.freud.file.entity.Attachment;
import org.freud.file.exception.AttachmentException;
import org.freud.file.interceptor.RequestContent;
import org.freud.file.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private AttachmentService attachmentService;

    @PostMapping("/up")
    public ResponseEntity<String> upLoadAttachment(@RequestParam("file") MultipartFile file) throws IOException {
        if (file == null) {
            throw new AttachmentException("上传文件失败，文件为空 !");
        }
        Integer currentId = RequestContent.getCurrentUser().getId();
        String attachmentId = attachmentService.saveAttachment(file, currentId);
        return new ResponseEntity<>(attachmentId, HttpStatus.OK);
    }

    @GetMapping("/down")
    public void downloadAttachment(@RequestParam("id") String id, HttpServletResponse response) {
        Attachment file = attachmentService.downloadAttachmentFile(id);
        try {
            String fileName = file.getName() + "." + file.getFileType();
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8);

            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            response.addHeader("Content-Length", "" + file.getContent().length);
            response.setContentType("application/octet-stream;charset=UTF-8");
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            outputStream.write(file.getContent());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.error("下载文件 [id: {}] 失败!! ", file.getId());
            throw new AttachmentException("下载文件失败!");
        }
    }

    @GetMapping("/photo")
    public void getPhotoById(@RequestParam("id") String id, HttpServletResponse response) {
        Attachment file = attachmentService.downloadAttachmentFile(id);
        try {
            response.setContentType("image/jpeg");
            response.setCharacterEncoding("UTF-8");
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(file.getContent());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            log.error("显示图片 [id: {}] 失败!! ", file.getId());
            throw new AttachmentException("下载文件失败!");
        }
    }

}
