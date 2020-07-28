package org.freud.group.client;

import org.freud.group.common.GroupDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "group")
public interface GroupClient {

    /***
     * 查询用户加入的群
     * @param userId
     * @return
     */
    @GetMapping("/service/queryUserGroups/{userId}")
    List<GroupDTO> queryUserGroups(@PathVariable("userId") Integer userId);

}
