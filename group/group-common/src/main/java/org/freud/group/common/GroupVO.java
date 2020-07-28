package org.freud.group.common;

import lombok.Data;

import java.io.Serializable;

/***
 * 群概要
 */
@Data
public class GroupVO implements Serializable {
    private Integer groupId;
    private String name;
    private Boolean joined; //是否已加入群
}
