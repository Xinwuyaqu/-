package com.chenpeng.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class Zuul_server_8080 {
    public static void main(String[] args) {
        SpringApplication.run(Zuul_server_8080.class, args);
    }
}
