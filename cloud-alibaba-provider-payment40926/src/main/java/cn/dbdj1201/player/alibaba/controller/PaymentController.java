package cn.dbdj1201.player.alibaba.controller;

import cn.dbdj1201.player.common.entities.CommonResult;
import cn.dbdj1201.player.common.entities.Payment;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author yz1201
 * @date 2020-07-22 10:28
 **/
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, IdUtil.simpleUUID()));
        hashMap.put(2L, new Payment(2L, IdUtil.simpleUUID()));
        hashMap.put(3L, new Payment(3L, IdUtil.simpleUUID()));
        hashMap.put(4L, new Payment(4L, IdUtil.simpleUUID()));
        hashMap.put(5L, new Payment(5L, IdUtil.simpleUUID()));
        hashMap.put(6L, new Payment(6L, IdUtil.simpleUUID()));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable Long id) {
        return new CommonResult<>(200, "from mysql, serverPort: " + serverPort, hashMap.get(id));
    }
}
