package cn.dbdj1201.player.alibaba.controller;

import cn.dbdj1201.player.alibaba.myhandler.CustomerBlockHandler;
import cn.dbdj1201.player.common.entities.CommonResult;
import cn.dbdj1201.player.common.entities.Payment;
import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yz1201
 * @date 2020-07-22 9:05
 **/
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult<Payment> byResource() {
        return new CommonResult<>(200, "按资源名称限流测试OK",
                new Payment(2020L, IdUtil.simpleUUID()));
    }

    public CommonResult<Object> handleException(BlockException e) {
        return new CommonResult<>(444, e.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按URL限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException2")
    public CommonResult<Payment> customerBlockHandler() {
        return new CommonResult<>(200, "按客户自定义测试OK", new Payment(2020L, IdUtil.simpleUUID()));
    }
}
