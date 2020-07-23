package com.chenpeng.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan("com.chenpeng.springcloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@SpringCloudApplication
public class Provider_product_hystrix_8004 {
    public static void main(String[] args) {

        SpringApplication.run(Provider_product_hystrix_8004.class, args);
    }
}
