package cn.dbdj1201.player.alibaba.myhandler;

import cn.dbdj1201.player.common.entities.CommonResult;
import cn.dbdj1201.player.common.entities.Payment;
import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author yz1201
 * @date 2020-07-22 9:42
 **/
public class CustomerBlockHandler {

    public static CommonResult<Object> handlerException1(BlockException exception) {
        return new CommonResult<>(4444444, "按客户自定义, global handlerException---------1");
    }

    public static CommonResult<Object> handlerException2(BlockException exception) {
        return new CommonResult<>(4444444, "按客户自定义, global handlerException---------2");
    }
}
