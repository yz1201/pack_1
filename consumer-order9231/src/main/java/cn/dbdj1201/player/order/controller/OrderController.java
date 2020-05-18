package cn.dbdj1201.player.order.controller;

import cn.dbdj1201.player.common.entities.CommonResult;
import cn.dbdj1201.player.common.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author tyz1201
 * @datetime 2020-05-16 21:10
 **/
@RestController
@RequestMapping(value = "/consumer")
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://127.0.0.1:9230";
    public static final String PAYMENT_URL = "http://SERVICE-PAYMENT";


    @Resource
    private RestTemplate template;

    @GetMapping(value = "payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return template.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return template.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
