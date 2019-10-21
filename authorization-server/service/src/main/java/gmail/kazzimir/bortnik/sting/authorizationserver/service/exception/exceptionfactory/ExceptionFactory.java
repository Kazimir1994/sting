package gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory;

import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.modelexception.BasicRuntimeException;
import org.springframework.http.HttpStatus;

public interface ExceptionFactory<R extends BasicRuntimeException, E extends Throwable> {
    R createRuntimeException(String message, Class clazz, HttpStatus status);

    E createException(String message, Class clazz);
}
