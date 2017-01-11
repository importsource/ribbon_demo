package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hezhuofan
 */
@Service
public class DemoService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackRegister", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")

    })
    public String register() {
        String tenantCode = "T-0001";
        String userName = "tom";
        String mobileNumber = "";
        String email = "";
        String password = "123456";

        String url = "http://EUREKA.CLIENT";
        String request = "";

        // 此方法有问题，待解决
        return restTemplate.getForObject(url, String.class);

    }

    private String fallbackRegister() {
        return "fallback";
    }
}
