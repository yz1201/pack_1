package cn.dbdj1201.player.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yz1201
 * @date 2020-07-22 18:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {

    private Long id;
    //产品id
    private Long productId;
    //总库存
    private Integer total;
    //已用库存
    private Integer used;
    //剩余库存
    private Integer residue;

}
