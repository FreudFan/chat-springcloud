package org.freud.user.utils;

import org.apache.commons.lang.math.NumberUtils;
import org.freud.user.enums.UserFormTypeEnum;
import org.freud.user.exception.FormException;

public class FormCheckUtil {

    public static UserFormTypeEnum checkInputType(String text) {
        if (text.contains("@")) {
            //识别是否是邮箱
            return UserFormTypeEnum.EMAIL;
        } else if (text.length() == 11 && NumberUtils.isDigits(text)) {
            //识别是手机号
            return UserFormTypeEnum.TELEPHONE;
        } else {
            throw new FormException("文本框输入格式错误");
        }
    }
}
