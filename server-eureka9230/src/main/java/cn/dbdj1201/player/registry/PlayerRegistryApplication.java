package cn.dbdj1201.player.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author tyz1201
 * @datetime 2020-05-18 16:20
 **/
@SpringBootApplication
@EnableEurekaServer
public class PlayerRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlayerRegistryApplication.class, args);
    }
}
