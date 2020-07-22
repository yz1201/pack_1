package cn.dbdj1201.player.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author yz1201
 * @date 2020-07-22 16:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_order")
public class Order {
    //主键id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //用户id
    private Long userId;
    //产品id
    private Long productId;
    //购买数量
    private Integer count;
    //应付金额
    private BigDecimal money;
    //订单状态，0：创建中；1：已完结
    private Integer status;
}
