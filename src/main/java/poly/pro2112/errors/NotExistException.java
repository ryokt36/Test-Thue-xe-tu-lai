package poly.pro2112.errors;

public class NotExistException extends RuntimeException {
    public NotExistException(String message, Throwable cause) {
        super("notExist-"+message, cause);
    }
}
