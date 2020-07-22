package cn.dbdj1201.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yz1201
 * @date 2020-07-20 10:41
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosPaymentConsumerMain40999 {
    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentConsumerMain40999.class, args);
    }
}
