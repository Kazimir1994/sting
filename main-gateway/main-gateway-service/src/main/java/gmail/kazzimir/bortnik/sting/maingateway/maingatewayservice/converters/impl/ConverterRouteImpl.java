package gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.converters.impl;

import gmail.kazzimir.bortnik.sting.maingateway.maingatewayrepository.model.Route;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.converters.Converter;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;

@Component
public class ConverterRouteImpl implements Converter<RouteDefinition, Route> {
    @Override
    public RouteDefinition toDTO(Route route) {
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(route.getId());
        routeDefinition.setUri(URI.create(route.getUri()));
        routeDefinition.setOrder(route.getOrder());
        routeDefinition.setPredicates(new ArrayList<>(route.getPredicates()));
        routeDefinition.setFilters(new ArrayList<>(route.getFilters()));
        return routeDefinition;
    }

    @Override
    public Route fromDTO(RouteDefinition routeDefinition) {
        throw new UnsupportedOperationException();
    }
}
