package com.chenpeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableHystrixDashboard
@EnableFeignClients
@EnableCircuitBreaker
public class Product_feign_consumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(Product_feign_consumer_80.class, args);
    }
}
