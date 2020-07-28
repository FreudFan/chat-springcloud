package org.freud.user.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoCheckVO implements Serializable {
    private Integer type;
    private String value;
}
