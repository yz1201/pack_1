package cn.dbdj1201.player.seata.controller;

import cn.dbdj1201.player.seata.domain.CommonResult;
import cn.dbdj1201.player.seata.domain.Order;
import cn.dbdj1201.player.seata.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yz1201
 * @date 2020-07-22 17:31
 **/
@RestController
@Slf4j
public class OrderController {

    @Resource
    private IOrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
