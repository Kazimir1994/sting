package gmail.kazzimir.bortnik.sting.centralgateway.centralgateway.config;


import gmail.kazzimir.bortnik.sting.centralgateway.centralgateway.config.model.GatewayRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinitionRouteLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static gmail.kazzimir.bortnik.sting.centralgateway.centralgateway.config.GatewayConfigProperties.AUTHORIZATION;
import static gmail.kazzimir.bortnik.sting.centralgateway.centralgateway.config.GatewayConfigProperties.RESOURCES;
import static gmail.kazzimir.bortnik.sting.centralgateway.centralgateway.config.model.GatewayRoutes.REPLACEMENT_NAME;

@Configuration
public class ConfigGateway {

    private final GatewayConfigProperties gatewayConfigProperties;

    @Autowired
    public ConfigGateway(GatewayConfigProperties gatewayConfigProperties) {
        this.gatewayConfigProperties = gatewayConfigProperties;
    }

    @Bean
    public RouteLocator createBeenGatewayRoutes(RouteLocatorBuilder builder) {
        GatewayRoutes gatewayRoutesAuthorization = gatewayConfigProperties.getRoutes().get(AUTHORIZATION);
        GatewayRoutes gatewayRoutesResources = gatewayConfigProperties.getRoutes().get(RESOURCES);
        return builder.routes()
                .route(r ->
                        r.path(gatewayRoutesAuthorization.getPath())
                                .filters(f -> f.rewritePath(gatewayRoutesAuthorization.getRewritePath(), REPLACEMENT_NAME))
                                .uri(gatewayRoutesAuthorization.getUrl())
                )
                .route(r -> r.path(gatewayRoutesResources.getPath())
                        .filters(f -> f.rewritePath(gatewayRoutesResources.getRewritePath(), REPLACEMENT_NAME))
                        .uri(gatewayRoutesResources.getUrl())
                )
                .build();
    }
}

