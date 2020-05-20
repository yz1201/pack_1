package cn.dbdj1201.player.order;

import cn.dbdj1201.player.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author tyz1201
 * @datetime 2020-05-16 21:04
 **/
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "SERVICE-PAYMENT", configuration = MyselfRule.class)
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
