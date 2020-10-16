package poly.pro2112.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AlreadyUsedException extends RuntimeException {
    public AlreadyUsedException(String message, Throwable cause) {
        super("existing-"+message, cause);
    }
}
