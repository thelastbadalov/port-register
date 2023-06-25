package az.ailab.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IncorrectData extends BadRequestException {
    public IncorrectData(String message) {
        super(message);
    }
}
