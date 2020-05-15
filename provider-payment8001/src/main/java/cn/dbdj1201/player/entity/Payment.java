package cn.dbdj1201.player.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author tyz1201
 * @datetime 2020-05-15 21:14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;            //主键
    private String serial;      //流水号
}
