package cn.dbdj1201.player.seata.service;

import cn.dbdj1201.player.seata.domain.Order;

/**
 * @author yz1201
 * @date 2020-07-22 16:59
 **/
public interface IOrderService {
    void create(Order order);
}
