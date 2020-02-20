package gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.ExceptionHandlers;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.api.ServerUnionController;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.model.ValidationErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(assignableTypes = ServerUnionController.class)
public class ServerUnionExceptionHandlers {
    private static final Logger logger = LoggerFactory.getLogger(ServerUnionExceptionHandlers.class);

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public final ResponseEntity notExistentHandler(Exception ex) {
        logger.info("Error:= {} ", ex.getMessage());
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        logger.info("Error:= {} ", ex.getMessage());
        ValidationErrorResponse error = new ValidationErrorResponse();
        List<ValidationErrorResponse.Violation> listErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> buildViolation(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        error.setViolations(listErrors);
        return error;
    }

    private ValidationErrorResponse.Violation buildViolation(String Field, String message) {
        return new ValidationErrorResponse.Violation(Field, message);
    }
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
//        Map<String, String> errors = new HashMap<>();
//
//        ex.getConstraintViolations().forEach(cv -> {
//            errors.put("message", cv.getMessage());
//            errors.put("path", (cv.getPropertyPath()).toString());
//        });
//
//        return errors;
//    }
}
