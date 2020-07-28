package org.freud.user.client;

import org.freud.user.common.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user")
public interface UserClient {

    /***
     * 查询用户基本信息
     * @param userId
     * @return
     */
    @GetMapping("/service/getUserVOInfo/{userId}")
    UserVO getUserVOInfo(@PathVariable("userId") Integer userId);

    /***
     * 查询用户基本信息
     * 如果是好友 添加好友备注
     * @param userId
     * @return
     */
    @GetMapping("/service/getUserVOInfoWithFriendFlag")
    UserVO getUserVOInfoWithFriendFlag(@RequestParam("userId") Integer userId,
                                       @RequestParam("currentId") Integer currentId);

}
