package gmail.kazzimir.bortnik.sting.authorizationserver.service.exception.exceptionfactory.modelexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;


public class BasicRuntimeException extends ResponseStatusException {
    private Map<String, Object> parameters = new HashMap<>();

    BasicRuntimeException(HttpStatus status, String message) {
        super(status, message);
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }
}
