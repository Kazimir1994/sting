package gmail.kazzimir.bortnik.sting.centralgateway.centralgateway.config;


import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory;
import org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.cloud.gateway.support.NameUtils.normalizeFilterFactoryName;
import static org.springframework.cloud.gateway.support.NameUtils.normalizeRoutePredicateName;

@Configuration
public class ConfigGateway implements RouteDefinitionRepository {
    public static final String REGEXP_KEY = "regexp";
    public static final String REPLACEMENT_KEY = "replacement";

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> routeDefinitions = new ArrayList<>();
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setUri(URI.create("http://localhost:9992"));

        List<PredicateDefinition> predicates = new ArrayList<>();
        PredicateDefinition predicateDefinition = new PredicateDefinition();
        predicates.add(predicateDefinition);
        predicateDefinition.setName(normalizeRoutePredicateName(PathRoutePredicateFactory.class));
        predicateDefinition.getArgs().put("Path", "/authorization/**");

        List<FilterDefinition> filters = new ArrayList<>();
        FilterDefinition filterDefinition = new FilterDefinition();
        filterDefinition.setName(normalizeFilterFactoryName(RewritePathGatewayFilterFactory.class));
        filterDefinition.addArg(REGEXP_KEY, "/authorization/(?<remaining>.*)");
        filterDefinition.addArg(REPLACEMENT_KEY, "/${remaining}");
        filters.add(filterDefinition);

        routeDefinition.setFilters(filters);
        routeDefinition.setPredicates(predicates);
        routeDefinitions.add(routeDefinition);

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

//    private final GatewayConfigProperties gatewayConfigProperties;
//
//    @Autowired
//    public ConfigGateway(GatewayConfigProperties gatewayConfigProperties) {
//        this.gatewayConfigProperties = gatewayConfigProperties;
//    }
//
//        @Bean
//    public RouteLocator createBeenGatewayRoutes(RouteLocatorBuilder builder) {
//        GatewayRoutes gatewayRoutesAuthorization = gatewayConfigProperties.getRoutes().get(AUTHORIZATION);
//        GatewayRoutes gatewayRoutesResources = gatewayConfigProperties.getRoutes().get(RESOURCES);
//        return builder.routes()
//                .route(r ->
//                        r.path(gatewayRoutesAuthorization.getPath())
//                                .filters(f -> f.rewritePath(gatewayRoutesAuthorization.getRewritePath(), REPLACEMENT_NAME))
//                                .uri(gatewayRoutesAuthorization.getUrl())
//                )
//                .route(r ->
//                        r.path(gatewayRoutesResources.getPath())
//                                .filters(f -> f.rewritePath(gatewayRoutesResources.getRewritePath(), REPLACEMENT_NAME))
//                                .uri(gatewayRoutesResources.getUrl())
//                )
//                .build();
//    }

}

