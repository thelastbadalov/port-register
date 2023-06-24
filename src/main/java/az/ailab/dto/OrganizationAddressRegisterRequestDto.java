package az.ailab.dto;

import az.ailab.enums.AddressTypeEnum;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class OrganizationAddressRegisterRequestDto {
    @NotEmpty(message = "address can not be null")
    private String address;
    @NotEmpty(message = "state can not be null")
    private String state;
    @NotEmpty(message = "city can not be null")
    private String city;
    @NotEmpty(message = "country can not be null")
    private String country;
    @NotEmpty(message = "postalCode can not be null")
    private String postalCode;

    private AddressTypeEnum addressType;

}
