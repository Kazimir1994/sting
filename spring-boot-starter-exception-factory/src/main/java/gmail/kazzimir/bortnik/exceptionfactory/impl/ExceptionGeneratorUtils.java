package gmail.kazzimir.bortnik.exceptionfactory.impl;

import gmail.kazzimir.bortnik.exceptionfactory.modelexception.CustomException;
import gmail.kazzimir.bortnik.exceptionfactory.modelexception.CustomRuntimeException;
import org.springframework.http.HttpStatus;

public class ExceptionGeneratorUtils {
    private static final String START_MESSAGE = "Error description := %s";

    public static CustomRuntimeException createRuntimeException(String message, HttpStatus status) {
        String messageRuntimeException = String.format(START_MESSAGE, message);
        return new CustomRuntimeException(status, messageRuntimeException);
    }

    public static void createAndThrowRuntimeException(String message, HttpStatus status) {
        throw createRuntimeException(message, status);
    }

    public static CustomException createException(String message, Class clazz) {
        String messageException = String.format(START_MESSAGE, message);
        return new CustomException(messageException);
    }
}
