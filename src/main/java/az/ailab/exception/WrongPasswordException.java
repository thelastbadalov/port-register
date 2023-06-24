package az.ailab.exception;

public class WrongPasswordException extends BadRequestException {

    public WrongPasswordException(String message) {
        super(message);
    }
}
