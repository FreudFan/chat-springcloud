package org.freud.group.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/***
 * 群公告
 */
@Data
public class NoticeDTO implements Serializable {
    private Integer id;

    /*** 公告标题 **/
    private String title;
    /*** 公告内容 **/
    private String content;
    /*** 上传用户 **/
    private Integer ownerId;
    /*** 所属群Id **/
    private Integer groupId;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
