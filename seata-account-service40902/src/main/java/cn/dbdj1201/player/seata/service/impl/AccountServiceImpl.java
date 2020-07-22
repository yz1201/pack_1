package cn.dbdj1201.player.seata.service.impl;

import cn.dbdj1201.player.seata.dao.IAccountDao;
import cn.dbdj1201.player.seata.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author yz1201
 * @date 2020-07-22 19:38
 **/
@Service
@Slf4j
public class AccountServiceImpl implements IAccountService {

    @Resource
    private IAccountDao accountDao;


    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------------>支付微服务开始调用支付");
        this.accountDao.decrease(userId, money);
        log.info("------------>支付微服务支付完成");
    }
}
