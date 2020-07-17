package cn.dbdj1201.player.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yz1201
 * @date 2020-07-17 13:15
 **/
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes().route("path_route_dbdj1201",
                r -> r.path("/inner")
                        .uri("https://www.baidu.com")).build();
    }
}
