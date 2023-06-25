package az.ailab.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrganizationOrUserAlreadyExists extends BadRequestException {

    public OrganizationOrUserAlreadyExists(String message) {
        super(message);
    }
}
