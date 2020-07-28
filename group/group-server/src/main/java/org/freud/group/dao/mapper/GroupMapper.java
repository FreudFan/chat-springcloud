package org.freud.group.dao.mapper;

import org.freud.group.common.GroupVO;
import org.freud.group.entity.Group;
import org.freud.user.common.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupMapper {

    /***
     * 查询用户加入的群
     * @param userId
     * @return
     */
    List<Group> queryUserJoinGroup(Integer userId);

    /***
     * 查询群成语列表
     * @param groupId
     * @return
     */
    List<UserVO> queryGroupUsers(Integer groupId);

    /***
     * 模糊搜索群名称
     * @param name 输入的群名称
     *
     * @return
     */
    List<GroupVO> searchGroup(String name);

    /***
     * 获取群成员id列表
     * @param groupId
     * @return
     */
    List<Integer> getGroupUsersId(Integer groupId);

}
