package az.ailab.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GeneralUserRegistrationRequestDto {

    @NotEmpty
    private String username;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String mobileNumber;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String confirmedEmail;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmedPassword;
}
