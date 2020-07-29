package org.freud.file.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/***
 * 文件表
 */
@Data
public class AttachmentDTO implements Serializable {
    private Integer id;
    /*** 文件名 **/
    private String name;
    /*** 文件大小 **/
    private String contentSize;
    /*** 文件类型 **/
    private String fileType;
    /*** 上传用户 **/
    private Integer ownerId;
    /*** 文件大字段 **/
    private byte[] content;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
