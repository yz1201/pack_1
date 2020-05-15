package cn.dbdj1201.player.service.impl;

import cn.dbdj1201.player.dao.PaymentDao;
import cn.dbdj1201.player.entity.Payment;
import cn.dbdj1201.player.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author tyz1201
 * @datetime 2020-05-15 21:39
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
