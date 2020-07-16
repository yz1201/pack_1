package cn.dbdj1201.player.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yz1201
 * @date 2020-07-16 8:33
 **/
public interface IPaymentService {
    String paymentInfo_OK(Long id);

    String paymentInfo_TimeOut(Long id);

    String paymentCircuitBreaker(Long id);
}
