package org.freud.file.client;

import org.freud.file.client.config.FeignMultipartSupportConfig;
import org.freud.file.common.AttachmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "file", configuration = FeignMultipartSupportConfig.class)
public interface FileClient {

    /***
     * 上传文件
     * @param file 文件
     * @param ownerId 文件拥有者 id
     * @return
     */
    @PostMapping(value = "/service/upLoadAttachment", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upLoadAttachment(@RequestPart("file") MultipartFile file, @RequestParam("ownerId") Integer ownerId);

    /***
     * 获取文件基本信息
     * @param fileId
     * @return
     */
    @GetMapping("/service/getAttachmentInfo")
    AttachmentDTO getAttachmentInfo(@RequestParam("fileId") String fileId);

    /***
     * 删除文件
     * @param fileId
     * @return
     */
    @PostMapping("/service/deleteAttachment")
    Boolean deleteAttachment(@RequestParam("fileId") String fileId);

}
