package cn.dbdj1201.player.seata.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author yz1201
 * @date 2020-07-22 19:33
 **/
@Mapper
public interface IAccountDao {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
