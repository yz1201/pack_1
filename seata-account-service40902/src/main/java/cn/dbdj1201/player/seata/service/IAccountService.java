package cn.dbdj1201.player.seata.service;

import java.math.BigDecimal;

/**
 * @author yz1201
 * @date 2020-07-22 19:37
 **/
public interface IAccountService {

    void decrease(Long userId, BigDecimal money);
}
