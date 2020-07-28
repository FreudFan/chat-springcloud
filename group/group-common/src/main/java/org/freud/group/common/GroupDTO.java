package org.freud.group.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/***
 * 用户群
 */
@Data
public class GroupDTO implements Serializable {
    private Integer id;

    /*** 群名称 **/
    private String name;
    /*** 群主id **/
    private Integer masterId;
    /*** 群logo **/
    private Integer icon;
    /*** 群简介 **/
    private String info;
    /*** 是否可用 1:可用  0:不可用，群已被解散 **/
    private Integer flag;

    private LocalDateTime createTime;
}
