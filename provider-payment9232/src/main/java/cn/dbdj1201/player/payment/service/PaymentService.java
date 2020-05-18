package cn.dbdj1201.player.payment.service;

import cn.dbdj1201.player.common.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author tyz1201
 * @datetime 2020-05-15 21:38
 **/
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
