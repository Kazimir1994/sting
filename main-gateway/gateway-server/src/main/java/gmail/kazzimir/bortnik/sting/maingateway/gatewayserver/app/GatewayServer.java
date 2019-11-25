package gmail.kazzimir.bortnik.sting.maingateway.gatewayserver.app;

import gmail.kazzimir.bortnik.sting.maingateway.gatewayrepository.impl.RouteRepository;
import gmail.kazzimir.bortnik.sting.maingateway.gatewayrepository.model.Route;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory;
import org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.cloud.gateway.support.NameUtils.normalizeFilterFactoryName;
import static org.springframework.cloud.gateway.support.NameUtils.normalizeRoutePredicateName;

@SpringBootApplication(scanBasePackages = "gmail.kazzimir.bortnik.sting.maingateway")
@EnableMongoRepositories("gmail.kazzimir.bortnik.sting.maingateway.gatewayrepository.impl")
public class GatewayServer implements CommandLineRunner {
    private final RouteRepository routeRepository;

    public GatewayServer(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayServer.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Route route = new Route();
//
//        route.setUri("http://localhost:9992");
//
//        List<PredicateDefinition> predicates = new ArrayList<>();
//        PredicateDefinition predicateDefinition = new PredicateDefinition();
//        predicates.add(predicateDefinition);
//        predicateDefinition.setName(normalizeRoutePredicateName(PathRoutePredicateFactory.class));
//        predicateDefinition.getArgs().put("Path", "/authorization/**");
//
//        List<FilterDefinition> filters = new ArrayList<>();
//        FilterDefinition filterDefinition = new FilterDefinition();
//        filterDefinition.setName(normalizeFilterFactoryName(RewritePathGatewayFilterFactory.class));
//        filterDefinition.addArg("regexp", "/authorization/(?<remaining>.*)");
//        filterDefinition.addArg("replacement", "/${remaining}");
//        filters.add(filterDefinition);
//
//        route.setFilters(filters);
//        route.setPredicates(predicates);
//        routeRepository.save(route);
    }
}
