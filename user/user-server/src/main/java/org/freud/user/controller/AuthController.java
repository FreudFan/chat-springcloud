package org.freud.user.controller;

import org.apache.commons.collections4.MapUtils;
import org.freud.user.common.UserInfoCheckVO;
import org.freud.user.common.UserVO;
import org.freud.user.entity.User;
import org.freud.user.enums.UserFormTypeEnum;
import org.freud.user.exception.FormException;
import org.freud.user.exception.LoginException;
import org.freud.user.interceptor.RequestContent;
import org.freud.user.service.UserService;
import org.freud.user.utils.FormCheckUtil;
import org.freud.user.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/login")
    public User login(@RequestBody Map<String, String> param, HttpSession session) {
        String text = MapUtils.getString(param, "text", null);
        String password = MapUtils.getString(param, "password", null);
        if (StringUtils.isEmpty(text) || StringUtils.isEmpty(password)) {
            throw new FormException("文本框输入格式错误");
        }
        UserFormTypeEnum loginValue = FormCheckUtil.checkInputType(text);
        User user = userService.login(loginValue, text, password);
        if (user != null) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user, userVO);
            session.setAttribute("user", userVO);
            redisUtil.putUser(userVO);
            RequestContent.add(userVO);
            return user;
        } else {
            throw new LoginException("用户名或密码错误");
        }
    }

    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
        RequestContent.remove();
    }

    /***
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user = userService.register(user);
        return user;
    }

    /***
     * 用户关键信息查重
     * @param checkVO
     * @return 无重复字段，返回 true
     */
    @PostMapping("/infoCheck")
    public boolean check(@RequestBody UserInfoCheckVO checkVO) {
        UserFormTypeEnum formTypeEnum = UserFormTypeEnum.getEnumByValue(checkVO.getType());
        return userService.check(formTypeEnum, checkVO.getValue());
    }
}
