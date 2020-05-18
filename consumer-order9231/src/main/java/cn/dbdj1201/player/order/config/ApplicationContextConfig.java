package cn.dbdj1201.player.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author tyz1201
 * @datetime 2020-05-16 21:32
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
