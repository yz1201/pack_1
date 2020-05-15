package cn.dbdj1201.player.dao;

import cn.dbdj1201.player.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-05-15 21:21
 **/
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

//    List<Payment> findAll();
//
//    int deletePaymentById(@Param("id") Long id);
//
//    int updatePaymentById(@Param("id") Long id);
}