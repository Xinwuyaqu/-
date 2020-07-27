package com.chenpeng.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chenpeng
 */
@SpringBootApplication
@MapperScan("com.chenpeng.springcloud.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
public class Provider_product_8002 {
    public static void main(String[] args) {

        SpringApplication.run(Provider_product_8002.class, args);
    }
}
