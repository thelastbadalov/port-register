package az.ailab.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
@Setter
public class CommonRegisterRequestDto {

    @Valid
    @JsonProperty("user")
    private GeneralUserRegistrationRequestDto userRegistrationRequestDto;

    @Valid
    @JsonProperty("organization")
    private OrganizationRegisterRequestDto organizationRegisterRequestDto;

    @Valid
    @JsonProperty("address")
    private OrganizationAddressRegisterRequestDto organizationAddressRegisterRequestDto;

}
