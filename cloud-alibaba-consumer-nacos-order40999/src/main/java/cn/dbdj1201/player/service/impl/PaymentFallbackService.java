package cn.dbdj1201.player.service.impl;

import cn.dbdj1201.player.common.entities.CommonResult;
import cn.dbdj1201.player.common.entities.Payment;
import cn.dbdj1201.player.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author yz1201
 * @date 2020-07-22 13:08
 **/
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444,
                "feign client call fail, ┭┮﹏┭┮",
                new Payment(id, "errorSerialNum"));
    }
}
