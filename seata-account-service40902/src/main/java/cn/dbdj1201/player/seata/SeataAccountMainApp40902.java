package cn.dbdj1201.player.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yz1201
 * @date 2020-07-22 19:29
 **/
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class SeataAccountMainApp40902 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApp40902.class, args);
    }
}
