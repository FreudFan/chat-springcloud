package org.freud.group.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class AcceptGroupVO implements Serializable {
    /***
     * 发送申请的群id
     */
    Integer sendGroupId;

    /***
     * 发送申请的用户id
     */
    Integer sendUserId;

    /***
     * 对群申请的操作
     * 枚举：OperatorGroupRequestTypeEnum
     */
    Integer operationType;
}
