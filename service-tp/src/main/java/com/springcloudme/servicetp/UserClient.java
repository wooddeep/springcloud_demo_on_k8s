package com.springcloudme.servicetp;

import com.springcloudme.servicetp.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-api", fallback = UserClientFallback.class)
public interface UserClient {

    @RequestMapping("/user/hi") // 对应 service-api 服务的 /user/hi的绝对路由
    String hi();

}