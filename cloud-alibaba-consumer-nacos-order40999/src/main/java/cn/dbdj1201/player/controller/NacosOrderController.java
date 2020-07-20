package cn.dbdj1201.player.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yz1201
 * @date 2020-07-20 10:48
 **/
@RestController
@Slf4j
public class NacosOrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/nacos/consumer/payment/get/{id}")
    public String getPayment(@PathVariable Long id) {
        return restTemplate.getForObject(serverUrl+"/nacos/payment/get/"+id, String.class);
    }
}
