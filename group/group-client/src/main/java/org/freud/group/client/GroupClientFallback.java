package org.freud.group.client;

import lombok.extern.slf4j.Slf4j;
import org.freud.group.common.GroupDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class GroupClientFallback implements GroupClient {
    @Override
    public List<GroupDTO> queryUserGroups(Integer userId) {
        log.error("调用【group】服务【queryUserGroups】接口失败！");
        return null;
    }

    @Override
    public List<Integer> getGroupUsersId(Integer groupId) {
        log.error("调用【group】服务【getGroupUsersId】接口失败！");
        return null;
    }

    @Override
    public String getUserGroupNickname(Integer groupId, Integer userId) {
        log.error("调用【group】服务【getUserGroupNickname】接口失败！");
        return null;
    }
}
