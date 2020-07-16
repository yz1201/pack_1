package cn.dbdj1201.player.service;

import org.springframework.stereotype.Component;

/**
 * @author yz1201
 * @date 2020-07-16 11:09
 **/
@Component
public class PaymentFallbackService implements IPaymentService {
    @Override
    public String paymentInfo_OK(Long id) {
        return "--PaymentFallbackService paymentInfo_OK ┗|｀O′|┛ 嗷~~ --";
    }

    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "--PaymentFallbackService paymentInfo_TimeOut ┗|｀O′|┛ 嗷~~ --";
    }
}
