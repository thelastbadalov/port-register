package az.ailab.dto;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
@Setter
public class CommonRegisterRequestDto {

    @Valid
    private GeneralUserRegistrationRequestDto userRegistrationRequestDto;
    @Valid
    private OrganizationRegisterRequestDto organizationRegisterRequestDto;
    @Valid
    private OrganizationAddressRegisterRequestDto organizationAddressRegisterRequestDto;

}
