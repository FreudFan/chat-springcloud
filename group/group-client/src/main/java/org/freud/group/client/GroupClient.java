package org.freud.group.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "group")
public interface GroupClient {


}
