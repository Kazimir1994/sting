package gmail.kazzimir.bortnik.exceptionfactory.modelexception;

import org.springframework.http.HttpStatus;

public class CustomRuntimeException extends BasicRuntimeException {
    public CustomRuntimeException(HttpStatus status, String message) {
        super(status, message);
    }
}
