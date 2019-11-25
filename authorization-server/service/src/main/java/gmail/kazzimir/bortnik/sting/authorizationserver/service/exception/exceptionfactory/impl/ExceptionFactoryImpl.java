package gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.impl;


import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.ExceptionFactory;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.modelexception.CustomException;
import gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.modelexception.CustomRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ExceptionFactoryImpl implements ExceptionFactory<CustomRuntimeException, CustomException> {
    private final String START_MESSAGE = "Error description := %s";

    @Override
    public CustomRuntimeException createRuntimeException(String message, HttpStatus status) {
        String messageRuntimeException = String.format(START_MESSAGE, message);
        return new CustomRuntimeException(status, messageRuntimeException);
    }

    @Override
    public void createAndThrowRuntimeException(String message, HttpStatus status) {
        throw createRuntimeException(message, status);
    }

    @Override
    public CustomException createException(String message, Class clazz) {
        String messageException = String.format(START_MESSAGE, message);
        return new CustomException(messageException);
    }
}
