package org.freud.file.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "group")
public interface FileClient {
}
