package org.freud.user.common;

import lombok.Data;

@Data
public class AcceptFriendVO {
    /***
     * 发送申请的用户id
     */
    Integer sendUserId;
    /***
     * 对好友申请的操作
     * 枚举：OperatorFriendRequestTypeEnum
     */
    Integer operationType;
}
