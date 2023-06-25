package az.ailab.service;

import az.ailab.dto.OrganizationAddressRegisterRequestDto;
import az.ailab.model.AddressType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrganizationAddressService {


    public AddressType createAddressType(OrganizationAddressRegisterRequestDto
                                                 organizationAddressRegisterRequestDto) {


        String code = organizationAddressRegisterRequestDto.getAddressType().toString();
        String name = organizationAddressRegisterRequestDto.getAddressType().getName();

        AddressType addressType = new AddressType();
        addressType.setCode(code);
        addressType.setName(name);
        addressType.setCreatedAt(LocalDateTime.now());
        addressType.setModifiedAt(LocalDateTime.now());
        return addressType;
    }
}
