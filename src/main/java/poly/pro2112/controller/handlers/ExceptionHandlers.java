package poly.pro2112.controller.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import poly.pro2112.errors.*;

public class ExceptionHandlers {
    @ExceptionHandler({ AlreadyUsedException.class })
    public ResponseEntity<String> handleAuthenticationException(AlreadyUsedException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler({ NotExistException.class })
    public ResponseEntity<String> handleAuthenticationException(NotExistException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
