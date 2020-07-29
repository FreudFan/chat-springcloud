package org.freud.file.utils;

import org.freud.user.common.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@Transactional
@Component("redisUtil")
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${spring.session.timeout}")
    private String timeout;

    /***
     * 将用户添加进在线用户列表
     * @param user
     */
    public void putUser(UserVO user) {
        redisTemplate.opsForHash().putAll(Prefix.USER + user.getId(), JacksonUtil.toMap(user));
        redisTemplate.expire(Prefix.USER + user.getId(), Duration.ofSeconds(Long.parseLong(timeout)));
    }

    public interface Prefix {
        /***
         * 在线用户列表
         */
        String USER = "user" + ":";
    }
}
