package gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.exception.configuration;

import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.exception.exceptionfactory.modelexception.BasicRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;


@Configuration
public class CustomErrorAttributes extends DefaultErrorAttributes {
    private static final Logger logger = LoggerFactory.getLogger(CustomErrorAttributes.class);

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, includeStackTrace);
        Throwable throwable = getError(request);

        if (throwable instanceof BasicRuntimeException) {
            BasicRuntimeException error = (BasicRuntimeException) throwable;
            Map<String, Object> extraParameters = error.getParameters();
            if (!isEmptyParameters(extraParameters)) {
                errorAttributes.putAll(extraParameters);
            }
            error.printStackTrace();
        }
        return errorAttributes;
    }

    private boolean isEmptyParameters(Map<String, Object> parameters) {
        return parameters.isEmpty();
    }
}
