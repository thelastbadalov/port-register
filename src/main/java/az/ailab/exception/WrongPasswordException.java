package az.ailab.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WrongPasswordException extends BadRequestException {

    public WrongPasswordException(String message) {
        super(message);
    }
}
