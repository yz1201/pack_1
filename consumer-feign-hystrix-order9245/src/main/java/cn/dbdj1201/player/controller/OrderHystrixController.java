package cn.dbdj1201.player.controller;

import cn.dbdj1201.player.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yz1201
 * @date 2020-07-16 9:43
 **/
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private IPaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Long id) {
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000")
//    })
//    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Long id) {
        return paymentService.paymentInfo_TimeOut(id);
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Long id) {
        return id + " consumer9245: 那边可能出问题了，等一会吧，或者你出问题了？ (●ˇ∀ˇ●)";
    }

    //全局默认降级方法
    public String payment_Global_FallbackMethod() {
        return "Global异常信息处理，请稍后再试，(￣y▽,￣)╭ ";
    }
}
