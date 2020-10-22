package org.freud.user.client;

import lombok.extern.slf4j.Slf4j;
import org.freud.user.common.UserVO;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class UserClientFallback implements UserClient {
    @Override
    public UserVO getUserVOInfo(Integer userId) {
        log.error("调用【user】服务【getUserVOInfo】接口失败！");
        return null;
    }

    @Override
    public UserVO getUserVOInfoWithFriendFlag(Integer userId, Integer currentId) {
        log.error("调用【user】服务【getUserVOInfoWithFriendFlag】接口失败！");
        return null;
    }
}
