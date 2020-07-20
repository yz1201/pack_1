package cn.dbdj1201.player.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yz1201
 * @date 2020-07-20 10:27
 **/
@RestController
@Slf4j
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/nacos/payment/get/{id}")
    public String getPayment(@PathVariable Long id) {
        return "welcome to nacos, id: " + id + ", from serverPort: " + serverPort;
    }
}
