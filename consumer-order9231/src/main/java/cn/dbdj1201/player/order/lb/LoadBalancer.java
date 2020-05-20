package cn.dbdj1201.player.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-05-20 21:20
 **/
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
