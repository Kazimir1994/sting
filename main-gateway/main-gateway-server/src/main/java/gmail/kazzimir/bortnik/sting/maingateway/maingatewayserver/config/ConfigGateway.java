package gmail.kazzimir.bortnik.sting.maingateway.maingatewayserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.InMemoryRouteDefinitionRepository;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Component
public class ConfigGateway extends InMemoryRouteDefinitionRepository {

    private final ApplicationEventPublisher publisher;

    @Autowired
    public ConfigGateway(ApplicationEventPublisher publisher) {
        new ArrayList<>();
        this.publisher = publisher;
    }

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return super.getRouteDefinitions();
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
        return super.save(route);
    }
}