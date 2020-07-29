package com.chenpeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="PRODUCT-PROVIDER")
public class Product_consumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(Product_consumer_80.class, args);
    }
}
