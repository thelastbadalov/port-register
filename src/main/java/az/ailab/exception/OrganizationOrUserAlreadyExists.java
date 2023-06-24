package az.ailab.exception;

public class OrganizationOrUserAlreadyExists extends RuntimeException{
    public OrganizationOrUserAlreadyExists() {
    }

    public OrganizationOrUserAlreadyExists(String message) {
        super(message);
    }
}
