package gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.modelexception;

import org.springframework.http.HttpStatus;

public class BasicRuntimeException extends RuntimeException {
    private HttpStatus status;

    BasicRuntimeException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
