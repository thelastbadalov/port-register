package az.ailab.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrganizationRegisterRequestDto {

    @NotEmpty(message = "organization name cant be empty")
    private String organizationName;

    @NotEmpty(message = "tax identificator number cant be empty")
    private String taxIdentificationNumber;

    @Email
    @NotEmpty(message = "email cant be empty")
    private String email_address;

    @NotEmpty(message = "organization phone number cant be empty")
    private String organizationPhoneNumber;

}
