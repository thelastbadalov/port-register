package az.ailab.dto;

import az.ailab.constants.AddressTypeEnum;
import az.ailab.constants.OrganizationAddressErrorMessages;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrganizationAddressRegisterRequestDto {
    @NotEmpty(message = OrganizationAddressErrorMessages.ADDRESS_NULL)
    private String address;
    @NotEmpty(message = OrganizationAddressErrorMessages.STATE_NULL)
    private String state;
    @NotEmpty(message = OrganizationAddressErrorMessages.CITY_NULL)
    private String city;
    @NotEmpty(message = OrganizationAddressErrorMessages.COUNTRY_NULL)
    private String country;
    @NotEmpty(message = OrganizationAddressErrorMessages.POSTAL_CODE_NULL)
    private String postalCode;

    private AddressTypeEnum addressType;

}
