package org.freud.group.common;

import lombok.Data;
import org.freud.user.common.UserVO;

import java.io.Serializable;
import java.time.LocalDateTime;

/***
 * 群概要
 */
@Data
public class GroupRequestVO implements Serializable {
    private Integer id;
    private Integer sendUserId;
    private Integer groupId;
    private UserVO userVo;
    private LocalDateTime requestDateTime;
}
