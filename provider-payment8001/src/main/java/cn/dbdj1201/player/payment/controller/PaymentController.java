package cn.dbdj1201.player.payment.controller;

import cn.dbdj1201.player.common.entities.CommonResult;
import cn.dbdj1201.player.common.entities.Payment;
import cn.dbdj1201.player.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public CommonResult<Payment> createPayment(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果： " + result + "? haha");
        CommonResult<Payment> commonResult;
        if (result > 0) {
            commonResult = new CommonResult(200, "插入成功", result);
        } else {
            commonResult = new CommonResult(444, "插入失败", null);
        }

        return commonResult;
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        CommonResult<Payment> result;
        Payment payment = this.paymentService.getPaymentById(id);
        if (payment != null)
            result = new CommonResult<>(200, "查询成功", payment);
        else
            result = new CommonResult<>(404, "查无此订单", null);
        return result;
    }
}
