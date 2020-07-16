package cn.dbdj1201.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yz1201
 * @date 2020-07-16 9:41
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain9245 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain9245.class, args);
    }
}
