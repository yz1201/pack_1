package cn.dbdj1201.player.payment.dao;

import cn.dbdj1201.player.common.entities.Payment;
import cn.dbdj1201.player.payment.PaymentApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Random;


/**
 * @author tyz1201
 * @datetime 2020-05-16 21:19
 **/
@SpringBootTest(classes = PaymentApplication.class)
@RunWith(SpringRunner.class)
public class PaymentDaoTest {

    @Resource
    private PaymentDao paymentDao;

    @Test
    public void create() {
        for (int i = 133; i < 1000; i++) {
            int anInt = new Random().nextInt(i);
            this.paymentDao.create(new Payment((long) i, String.valueOf(anInt)));
        }
    }

    @Test
    public void getPaymentById() {
    }
}