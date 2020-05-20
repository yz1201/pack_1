package cn.dbdj1201.player.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author tyz1201
 * @datetime 2020-05-19 22:50
 **/
@RestController
@Slf4j
public class OrderController {
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo() {
        log.info("ni ren ne?");
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
//        return "wo da le";
    }
}
