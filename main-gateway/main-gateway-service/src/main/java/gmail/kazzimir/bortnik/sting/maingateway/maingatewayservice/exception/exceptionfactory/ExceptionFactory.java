package gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.exception.exceptionfactory;


import gmail.kazzimir.bortnik.sting.maingateway.maingatewayservice.exception.exceptionfactory.modelexception.BasicRuntimeException;
import org.springframework.http.HttpStatus;

public interface ExceptionFactory<R extends BasicRuntimeException, E extends Throwable> {
    R createRuntimeException(String message, HttpStatus status);

    void createAndThrowRuntimeException(String message, HttpStatus status);

    E createException(String message, Class clazz);
}
