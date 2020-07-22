package cn.dbdj1201.player.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yz1201
 * @date 2020-07-22 18:54
 **/
@Mapper
public interface IStorageDao {
    //根据数量减少响应用户库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
