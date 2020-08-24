package com.springcloudme.servicetp.controller;

import com.springcloudme.servicetp.UserClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ApiController {

	@RequestMapping(value = "/me",method = RequestMethod.GET)
	public String  getUser(){
		return "hjashdahsdha";
	}

	@Autowired
    private UserClient userClient;

    @RequestMapping("/hi")
    public String hi() {
        return userClient.hi();
    }
}
