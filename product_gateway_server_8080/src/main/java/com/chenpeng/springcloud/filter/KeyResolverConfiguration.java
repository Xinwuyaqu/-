package com.chenpeng.springcloud.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class KeyResolverConfiguration {
    /*
    * 基于请求路径的限流
    * */
    @Bean
    public KeyResolver PathKeyResolver(){
        return exchange -> Mono.just(
                exchange.getRequest().getPath().toString()
        );
    }

    /*
     * 基于请求ip地址的限流
     * */
//    @Bean
    public KeyResolver IpKeyResolver(){
        return exchange -> Mono.just(
                exchange.getRequest().getHeaders().getFirst("X-Forwarded-For")
        );
    }

    /*
     * 基于请求用户的限流
     * */
//    @Bean
    public KeyResolver UserKeyResolver(){
        return exchange -> Mono.just(
                exchange.getRequest().getQueryParams().getFirst("user")
        );
    }
}
