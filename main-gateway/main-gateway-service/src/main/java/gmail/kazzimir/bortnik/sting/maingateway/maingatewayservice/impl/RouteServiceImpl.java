package gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.impl;

import gmail.kazzimir.bortnik.exceptionfactory.impl.ExceptionGeneratorUtils;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayrepository.impl.RouteRepository;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayrepository.model.Route;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.RouteService;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.converters.Converter;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.messageexception.MessageException.ERROR_ROUTES_NOT_EXIST;


@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final Converter<RouteDefinition, Route> converterRoute;

    public RouteServiceImpl(RouteRepository routeRepository,
                            Converter<RouteDefinition, Route> converterRoute) {
        this.routeRepository = routeRepository;
        this.converterRoute = converterRoute;
    }

    @Override
    @Transactional
    public Collection<RouteDefinition> getALL() {
        List<Route> allRoute = routeRepository.findAll();
        if (allRoute.isEmpty()) {
            ExceptionGeneratorUtils.createAndThrowRuntimeException(ERROR_ROUTES_NOT_EXIST, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return converterRoute.listToDTO(allRoute);
    }

}
