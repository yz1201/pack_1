package cn.dbdj1201.player.seata.service.impl;

import cn.dbdj1201.player.seata.dao.OrderDao;
import cn.dbdj1201.player.seata.domain.Order;
import cn.dbdj1201.player.seata.service.IAccountService;
import cn.dbdj1201.player.seata.service.IOrderService;
import cn.dbdj1201.player.seata.service.IStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yz1201
 * @date 2020-07-22 16:59
 **/
@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private IStorageService storageService;

    @Resource
    private IAccountService accountService;

    @Override
    @GlobalTransactional(name = "seata-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("---------->开始新建订单");
        orderDao.create(order);
        log.info("---------->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("---------->订单微服务开始调用库存，做扣减end");
        log.info("---------->订单微服务开始调用支付，做支付");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("---------->订单微服务开始调用支付，支付完成");
        log.info("---------->订单微服务开始修改订单状态");
        //修改订单状态，从0-1，代表订单已经走完了，从提交到库存减少到支付流程已完成。
        orderDao.update(order.getUserId(), 0);
        log.info("---------->订单微服务修改订单状态完成");
        log.info("---------->完成订单 O(∩_∩)O");
    }
}
