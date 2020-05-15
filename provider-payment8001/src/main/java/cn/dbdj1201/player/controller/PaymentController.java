package cn.dbdj1201.player.controller;

import cn.dbdj1201.player.entity.CommonResult;
import cn.dbdj1201.player.entity.Payment;
import cn.dbdj1201.player.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tyz1201
 * @datetime 2020-05-15 21:43
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult createPayment(Payment payment) {
        int result = paymentService.create(payment);

        if (result > 0) {
            return new CommonResult(200, "", result);
        } else {
            return new CommonResult(444, "插入失败");
        }
    }
}
