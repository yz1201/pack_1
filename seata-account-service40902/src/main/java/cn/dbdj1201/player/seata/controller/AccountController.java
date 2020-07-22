package cn.dbdj1201.player.seata.controller;

import cn.dbdj1201.player.seata.domain.CommonResult;
import cn.dbdj1201.player.seata.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author yz1201
 * @date 2020-07-22 19:40
 **/
@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/account/decrease")
    public CommonResult decreaseAccount(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        this.accountService.decrease(userId,money);
        return new CommonResult(200,"支付成功");
    }
}
