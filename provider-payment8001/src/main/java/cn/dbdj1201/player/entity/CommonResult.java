package cn.dbdj1201.player.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tyz1201
 * @datetime 2020-05-15 21:17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;   //http状态码
    private String message; //返回信息
    private T data;         //实体数据

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
