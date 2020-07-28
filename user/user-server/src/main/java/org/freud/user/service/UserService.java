package org.freud.user.service;

import org.freud.group.common.GroupDTO;
import org.freud.user.common.MyFriendsVO;
import org.freud.user.common.UserVO;
import org.freud.user.entity.User;
import org.freud.user.enums.UserFormTypeEnum;

import java.util.List;

public interface UserService {

    /***
     * 若登录失败，返回null
     * @param loginValue
     * @param name
     * @param password
     * @return
     */
    User login(UserFormTypeEnum loginValue, String name, String password);

    /***
     * 用户注册
     * @param user
     * @return
     */
    User register(User user);

    /***
     * 查重
     * @param userFormTypeEnum
     * @param value
     * @return
     */
    boolean check(UserFormTypeEnum userFormTypeEnum, String value);

    /***
     * 模糊搜索用户
     * @param name 用户名
     * @return
     */
    List<UserVO> searchUser(String name);

    /***
     * 查询用户好友列表
     * @param userId
     * @return
     */
    List<MyFriendsVO> queryMyFriends(Integer userId);

    /***
     * 查询用户信息
     * @param userId
     * @return
     */
    User getUserInfo(Integer userId);

    /***
     * 修改用户信息
     * @param user
     * @return
     */
    User changeUserInfo(User user);

    /***
     * 查询加入的群
     * @param userId
     * @return
     */
    List<GroupDTO> queryMyGroups(Integer userId);

    /***
     * 查询陌生人基本信息
     * @param userId
     * @return
     */
    UserVO getUserVOById(Integer userId);
}
