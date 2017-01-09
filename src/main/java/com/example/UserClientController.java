package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/register")
    public String register(){

        String tenantCode = "T-0001";
        String userName = "tom";
        String mobileNumber = "";
        String email = "";
        String password = "123456";

        String url = "http://EUREKA.CLIENT";
        String request = "";

        // 此方法有问题，待解决
        restTemplate.postForLocation(url, request, tenantCode, userName, mobileNumber, email, password);

        return "ok";
    }
}
