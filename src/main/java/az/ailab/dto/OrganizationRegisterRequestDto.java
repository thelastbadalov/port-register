package az.ailab.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrganizationRegisterRequestDto {

    @NotEmpty(message = "organization name can't be empty")
    private String organizationName;

    @NotEmpty(message = "tax identification number can't be empty")
    private String taxIdentificationNumber;

    @Email
    @NotEmpty(message = "email cant be empty")
    private String email_address;

    @NotEmpty(message = "organization phone number can't be empty")
    private String organizationPhoneNumber;

}
