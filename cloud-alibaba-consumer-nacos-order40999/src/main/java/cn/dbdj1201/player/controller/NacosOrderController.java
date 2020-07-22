package cn.dbdj1201.player.controller;

import cn.dbdj1201.player.common.entities.CommonResult;
import cn.dbdj1201.player.common.entities.Payment;
import cn.dbdj1201.player.service.PaymentService;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yz1201
 * @date 2020-07-20 10:48
 **/
@RestController
@Slf4j
public class NacosOrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/nacos/consumer/payment/get/{id}")
    public String getPayment(@PathVariable Long id) {
        return restTemplate.getForObject(serverUrl + "/nacos/payment/get/" + id, String.class);
    }

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "findPayment_block")
    public CommonResult findPayment(@PathVariable Long id) {
        CommonResult result = restTemplate.getForObject(serverUrl + "/paymentSQL/" + id, CommonResult.class);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        } else {
            assert result != null;
            if (result.getData() == null) {
                throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
            }
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        return new CommonResult(44444444, "异常处理中，请稍后再拨，😊  " + e.getMessage(), new Payment(id, null));
    }

    public CommonResult findPayment_block(@PathVariable Long id, BlockException e) {
        return new CommonResult(444, "配置不太行，懂了不/(ㄒoㄒ)/~~" + e.getMessage(), new Payment(id, null));

    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable Long id) {
        return this.paymentService.paymentSQL(id);
    }

}
