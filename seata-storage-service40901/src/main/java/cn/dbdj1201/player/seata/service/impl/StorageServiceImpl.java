package cn.dbdj1201.player.seata.service.impl;

import cn.dbdj1201.player.seata.dao.IStorageDao;
import cn.dbdj1201.player.seata.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yz1201
 * @date 2020-07-22 19:14
 **/
@Service
@Slf4j
public class StorageServiceImpl implements IStorageService {

    @Resource
    private IStorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----------->库存微服务接受订单调用，开始削减库存");
        this.storageDao.decrease(productId, count);
        log.info("----------->库存微服务完成库存量削减");
    }
}
