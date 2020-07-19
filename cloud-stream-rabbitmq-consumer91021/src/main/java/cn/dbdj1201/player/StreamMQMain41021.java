package cn.dbdj1201.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yz1201
 * @date 2020-07-19 14:15
 **/
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain41021 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain41021.class, args);
    }
}
