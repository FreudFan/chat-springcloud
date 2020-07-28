package org.freud.user.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MyFriendsVO implements Serializable {
    /*** 分组id **/
    private Integer groupId;
    /*** 分组名称 **/
    private String groupName;
    /*** 好友列表 **/
    private List<UserVO> users;
}
