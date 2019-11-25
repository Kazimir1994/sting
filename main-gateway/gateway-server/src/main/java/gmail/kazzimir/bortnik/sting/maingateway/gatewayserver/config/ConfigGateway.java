package gmail.kazzimir.bortnik.sting.maingateway.gatewayserver.config;


import gmail.kazzimir.bortnik.sting.maingateway.gatewayservice.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Configuration
public class ConfigGateway implements RouteDefinitionRepository {
    private static final Logger logger = LoggerFactory.getLogger(ConfigGateway.class);
    private final RouteService routeService;

    public ConfigGateway(RouteService routeService) {
        this.routeService = routeService;
    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        logger.info("Route initialization...");
        Collection<RouteDefinition> routeDefinitions = routeService.getALL();
        logger.info("list of routes := {}", routeDefinitions);
        return Flux.fromIterable(routeDefinitions);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }

}

