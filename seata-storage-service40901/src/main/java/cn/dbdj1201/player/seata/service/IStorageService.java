package cn.dbdj1201.player.seata.service;


/**
 * @author yz1201
 * @date 2020-07-22 19:12
 **/
public interface IStorageService {

    void decrease(Long productId, Integer count);

}
