package cn.dbdj1201.player.controller;

import cn.dbdj1201.player.entity.CommonResult;
import cn.dbdj1201.player.entity.Payment;
import cn.dbdj1201.player.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tyz1201
 * @datetime 2020-05-15 21:43
 **/
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "create")
    public CommonResult<Payment> createPayment(Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果： " + result);
        CommonResult<Payment> commonResult;
        if (result > 0) {
            commonResult = new CommonResult(200, "插入成功", result);
        } else {
            commonResult = new CommonResult(444, "插入失败", null);
        }

        return commonResult;
    }

    @GetMapping(value = "get/{id}")
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
