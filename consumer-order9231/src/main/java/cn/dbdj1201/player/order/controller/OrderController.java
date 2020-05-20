package cn.dbdj1201.player.order.controller;

import cn.dbdj1201.player.common.entities.CommonResult;
import cn.dbdj1201.player.common.entities.Payment;
import cn.dbdj1201.player.order.lb.LoadBalancer;
import cn.dbdj1201.player.order.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-05-16 21:10
 **/
@RestController
@RequestMapping(value = "/consumer")
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL = "http://127.0.0.1:9230";
    public static final String PAYMENT_URL = "http://SERVICE-PAYMENT";

    @Resource
    private RestTemplate template;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return template.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return template.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = template.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful())
            return entity.getBody();
        else
            return new CommonResult<>(444, "操作失败");
    }

    @GetMapping("payment/testCreate")
    public CommonResult<Payment> createPayment(Payment payment) {
        System.out.println("payment->" + payment);
        ResponseEntity<CommonResult> entity = template.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            log.info("di di -> " + entity.getStatusCode() + "->" + entity.getHeaders());
            return entity.getBody();
        } else
            return new CommonResult<>(444, "出问题了");
    }

    @GetMapping("payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("SERVICE-PAYMENT");
        if (instances == null || instances.size() <= 0)
            return null;
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return template.getForObject(uri + "/payment/lb", String.class);
    }

}
