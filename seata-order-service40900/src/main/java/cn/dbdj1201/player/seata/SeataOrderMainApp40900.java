package cn.dbdj1201.player.seata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yz1201
 * @date 2020-07-22 16:46
 **/
//取消数据源的自动创建
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrderMainApp40900 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp40900.class, args);
    }
}
