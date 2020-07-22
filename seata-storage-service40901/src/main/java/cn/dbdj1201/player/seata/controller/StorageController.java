package cn.dbdj1201.player.seata.controller;

import cn.dbdj1201.player.seata.domain.CommonResult;
import cn.dbdj1201.player.seata.service.IStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yz1201
 * @date 2020-07-22 19:16
 **/
@RestController
@Slf4j
public class StorageController {

    @Resource
    private IStorageService storageService;

    @PostMapping("/storage/decrease")
    public CommonResult decreaseStorage(@RequestParam("productId") Long productId,
                                        @RequestParam("count") Integer count) {
        this.storageService.decrease(productId, count);
        return new CommonResult(200, "库存已削减");
    }
}
