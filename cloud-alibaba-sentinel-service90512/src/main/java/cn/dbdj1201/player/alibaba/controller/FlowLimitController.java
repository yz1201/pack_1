package cn.dbdj1201.player.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author yz1201
 * @date 2020-07-21 13:04
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
//        try {
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t....testB");
        return "testB";
    }


    @GetMapping("/testC")
    public String testC() {
        log.info(Thread.currentThread().getName() + "\t....testC");
        int age = 10 / 0;
        return "testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
//        int num = 2 / 0;
        return p1 + " test hot key " + p2;
    }

    public String deal_testHotKey(String p1, String p2, BlockException e) {
        e.printStackTrace();
//        log.info(e);
        return p1 + "\t" + p2 + "----deal_test_hot_key, ┭┮﹏┭┮";
    }

//    public String deal_others(String p1, String p2, BlockException e) {
//        log.info("i am a stupid person");
//        return p1 + "\t" + p2 + "----deal_test_hot_key, ┭┮﹏┭┮";
//    }
}
