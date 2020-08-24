package com.springcloudme.servicetp;

import com.springcloudme.servicetp.UserClient;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public String hi() {
        return "Oh! Error!!!";
    }
}