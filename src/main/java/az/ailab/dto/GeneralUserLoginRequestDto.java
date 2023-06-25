package az.ailab.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class GeneralUserLoginRequestDto {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;
}
