package cn.dbdj1201.player.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author tyz1201
 * @datetime 2020-05-16 23:05
 **/
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    //http状态码
    private Integer code;
    //返回信息
    private String message;
    //实体数据
    private T data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}