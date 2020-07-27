package org.freud.user.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user")
public interface UserClient {
}
