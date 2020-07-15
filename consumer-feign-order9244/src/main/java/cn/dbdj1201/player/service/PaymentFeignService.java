package cn.dbdj1201.player.service;

import cn.dbdj1201.player.common.entities.CommonResult;
import cn.dbdj1201.player.common.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yz1201
 * @date 2020-07-15 16:26
 **/
@Component
@FeignClient(value = "service-payment")
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
