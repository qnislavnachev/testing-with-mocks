package servicetask;

/**
 * Exception that is thrown by  userRepository method.
 */
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
    }
}
