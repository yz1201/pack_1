package cn.dbdj1201.player.seata.service;

import cn.dbdj1201.player.seata.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author yz1201
 * @date 2020-07-22 17:15
 **/
@FeignClient(name = "seata-account-service")
public interface IAccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
