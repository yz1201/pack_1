package cn.dbdj1201.player.seata.dao;

import cn.dbdj1201.player.seata.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yz1201
 * @date 2020-07-22 17:03
 **/
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);

    //修改订单状态，从0->1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
