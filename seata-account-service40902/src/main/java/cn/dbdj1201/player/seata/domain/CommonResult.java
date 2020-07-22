package cn.dbdj1201.player.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yz1201
 * @date 2020-07-22 18:49
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //响应状态码
    private Integer statusCode;
    //响应信息
    private String message;
    //携带数据
    private T data;

    public CommonResult(Integer statusCode, String message) {
        this(statusCode, message, null);
    }
}
