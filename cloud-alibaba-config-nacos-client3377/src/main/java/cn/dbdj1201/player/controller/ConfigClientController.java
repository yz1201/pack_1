package cn.dbdj1201.player.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yz1201
 * @date 2020-07-20 11:24
 **/
@Slf4j
@RestController
@RefreshScope //支持Nacos的动态刷新功能
public class ConfigClientController {

    @Value(("${config.info}"))
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
