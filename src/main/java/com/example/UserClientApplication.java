package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hezhuofan
 */
@SpringBootApplication
@EnableDiscoveryClient //添加服务发现能力
@EnableEurekaClient  //添加注册能力
@EnableHystrix  //增加hystrix能力
@EnableHystrixDashboard //
@EnableAutoConfiguration  //增加配置能力
@EnableSwagger2 //增加文档支持能力
@EnableFeignClients //增加feign
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
