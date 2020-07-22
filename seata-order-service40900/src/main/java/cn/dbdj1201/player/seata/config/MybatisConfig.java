package cn.dbdj1201.player.seata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author yz1201
 * @date 2020-07-22 17:38
 **/
@Configuration
@MapperScan("cn.dbdj1201.player.seata.dao")
public class MybatisConfig {
}
