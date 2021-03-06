package com.example.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("EUREKA.CLIENT")
public interface NounClient {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  String getWord();
}
