package cn.dbdj1201.player.service.impl;

import cn.dbdj1201.player.service.IPaymentService;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author yz1201
 * @date 2020-07-16 8:33
 **/
@Service
public class PaymentServiceImpl implements IPaymentService {


    /**
     * 正常访问，肯定没问题
     *
     * @param id
     * @return 返回处理线程信息
     */
    @Override
    public String paymentInfo_OK(Long id) {
        return "线程池-" + Thread.currentThread().getName() + " paymentInfo_OK, id: "
                + id + "\t" + "O(∩_∩)O";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @Override
    public String paymentInfo_TimeOut(Long id) {
        int assumeTime = 3;
        try {
            TimeUnit.SECONDS.sleep(assumeTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池-" + Thread.currentThread().getName() + " paymentInfo_Timeout, id: "
                + id + "\t" + "O(∩_∩)O 耗时" + assumeTime + "秒钟";
    }

    public String paymentInfo_TimeoutHandler(Long id) {
        return "线程池-" + Thread.currentThread().getName() + " 9236paymentInfo_TimeoutHandler, id: "
                + id + "\t" + "┭┮﹏┭┮ 出问题了哥哥";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时机窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        if (id < 0) {
            throw new RuntimeException("id can't be negative");
        }

        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号： " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Long id) {
        return "id can't be negative ┭┮﹏┭┮， id: " + id;
    }
}
