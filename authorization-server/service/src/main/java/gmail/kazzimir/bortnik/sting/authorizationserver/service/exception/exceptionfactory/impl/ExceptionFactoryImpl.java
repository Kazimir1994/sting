package gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.impl;

import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.ExceptionFactory;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.modelexception.CustomException;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.modelexception.CustomRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFactoryImpl implements ExceptionFactory<CustomRuntimeException, CustomException> {
    private final String START_MESSAGE = "In service -> %s an error occurred.Error description := %s";

    @Override
    public CustomRuntimeException createRuntimeException(String message, Class clazz, HttpStatus status) {
        String messageRuntimeException = String.format(START_MESSAGE, clazz.getName(), message);
        return new CustomRuntimeException(status, messageRuntimeException);
    }

    @Override
    public CustomException createException(String message, Class clazz) {
        String messageException = String.format(START_MESSAGE, clazz.getName(), message);
        return new CustomException(messageException);
    }
}
