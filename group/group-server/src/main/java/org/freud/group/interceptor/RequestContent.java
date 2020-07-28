package org.freud.group.interceptor;

import org.freud.user.common.UserVO;

/***
 * 请求内容
 */
public class RequestContent {
    /*** 用户 */
    private static final ThreadLocal<UserVO> userHolder = new ThreadLocal<>();

    public static void add(UserVO user) {
        userHolder.set(user);
    }

    public static UserVO getCurrentUser() {
        return userHolder.get();
    }

    public static void remove() {
        userHolder.remove();
    }

}
