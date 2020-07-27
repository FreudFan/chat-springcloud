package org.freud.group.common;

import lombok.Data;

@Data
public class GroupAttachmentVO {
    /*** 文件自身的id **/
    private String fileId;
    /*** 文件名 **/
    private String fileName;
    /*** 文件大小 **/
    private String contentSize;
    /*** 上传该群文件的用户信息 **/
    private UserVO userVO;
}
