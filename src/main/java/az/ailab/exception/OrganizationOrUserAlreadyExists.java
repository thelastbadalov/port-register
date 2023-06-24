package az.ailab.exception;

public class OrganizationOrUserAlreadyExists extends BadRequestException{
    public OrganizationOrUserAlreadyExists() {
    }

    public OrganizationOrUserAlreadyExists(String message) {
        super(message);
    }
}
