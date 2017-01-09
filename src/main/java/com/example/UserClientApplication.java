package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author hezhuofan
 */
@SpringBootApplication
@EnableDiscoveryClient //添加服务发现能力
@EnableEurekaClient
@EnableAutoConfiguration
public class UserClientApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

   // public static void main(String[] args) {
      //  SpringApplication.run(UserClientApplication.class,args);
   // }
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserClientApplication.class).web(true).run(args);
    }

}