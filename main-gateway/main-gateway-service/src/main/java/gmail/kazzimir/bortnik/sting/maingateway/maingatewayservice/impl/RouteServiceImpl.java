package gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.impl;

import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.RouteService;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.converters.Converter;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.exception.exceptionfactory.ExceptionFactory;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.exception.exceptionfactory.modelexception.CustomException;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.exception.exceptionfactory.modelexception.CustomRuntimeException;

import gmail.kazzimir.bortnik.sting.maingateway.maingatewayrepository.impl.RouteRepository;
import gmail.kazzimir.bortnik.sting.maingateway.maingatewayrepository.model.Route;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.exception.messageexception.MessageException.ERROR_ROUTES_NOT_EXIST;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final Converter<RouteDefinition, Route> converterRoute;
    private final ExceptionFactory<CustomRuntimeException, CustomException> exceptionFactory;

    public RouteServiceImpl(RouteRepository routeRepository,
                            Converter<RouteDefinition, Route> converterRoute,
                            ExceptionFactory<CustomRuntimeException, CustomException> exceptionFactory) {
        this.routeRepository = routeRepository;
        this.converterRoute = converterRoute;
        this.exceptionFactory = exceptionFactory;
    }

    @Override
    @Transactional
    public Collection<RouteDefinition> getALL() {
        List<Route> allRoute = routeRepository.findAll();
        if (allRoute.isEmpty()) {
            exceptionFactory.createAndThrowRuntimeException(ERROR_ROUTES_NOT_EXIST, HttpStatus.SERVICE_UNAVAILABLE);
        }
        return converterRoute.listToDTO(allRoute);
    }

}
