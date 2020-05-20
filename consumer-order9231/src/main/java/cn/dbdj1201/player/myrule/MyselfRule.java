package cn.dbdj1201.player.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tyz1201
 * @datetime 2020-05-20 20:41
 **/
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule() {
        return new RandomRule();//随机返回机制
    }
}
