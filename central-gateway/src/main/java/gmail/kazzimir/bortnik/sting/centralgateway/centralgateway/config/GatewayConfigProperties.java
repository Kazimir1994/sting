package gmail.kazzimir.bortnik.sting.centralgateway.centralgateway.config;

import gmail.kazzimir.bortnik.sting.centralgateway.centralgateway.config.model.GatewayRoutes;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("gateway")
public class GatewayConfigProperties {
    final static String AUTHORIZATION = "authorization";
    final static String RESOURCES = "resources";
    private Map<String, GatewayRoutes> routes = new LinkedHashMap<>();

    public Map<String, GatewayRoutes> getRoutes() {
        return routes;
    }

    public void setRoutes(Map<String, GatewayRoutes> routes) {
        this.routes = routes;
    }
}

