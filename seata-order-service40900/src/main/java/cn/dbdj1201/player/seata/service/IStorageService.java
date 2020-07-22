package cn.dbdj1201.player.seata.service;

import cn.dbdj1201.player.seata.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yz1201
 * @date 2020-07-22 17:15
 **/
@FeignClient(value = "seata-storage-service")
public interface IStorageService {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
