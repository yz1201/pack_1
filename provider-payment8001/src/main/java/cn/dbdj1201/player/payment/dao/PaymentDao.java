package cn.dbdj1201.player.payment.dao;

import cn.dbdj1201.player.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tyz1201
 * @datetime 2020-05-15 21:21
 **/
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

//    List<Payment> findAll();
//
//    int deletePaymentById(@Param("id") Long id);
//
//    int updatePaymentById(@Param("id") Long id);
}
