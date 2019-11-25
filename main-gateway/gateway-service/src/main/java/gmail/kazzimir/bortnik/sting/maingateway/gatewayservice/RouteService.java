package gmail.kazzimir.bortnik.sting.maingateway.gatewayservice;

import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.Collection;

public interface RouteService {
    Collection<RouteDefinition> getALL();
}
