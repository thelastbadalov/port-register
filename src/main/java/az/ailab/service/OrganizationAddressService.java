package az.ailab.service;

import az.ailab.dto.GenericResponse;
import az.ailab.dto.OrganizationAddressRegisterRequestDto;
import az.ailab.mapstruct.OrganizationAddressMapper;
import az.ailab.model.AddressType;
import az.ailab.model.OrganizationAddress;
import az.ailab.repository.AddressTypeRepository;
import az.ailab.repository.OrganizationAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrganizationAddressService {

    private final OrganizationAddressMapper organizationAddressMapper;
    private final OrganizationAddressRepository organizationAddressRepository;
    private final AddressTypeRepository addressTypeRepository;

    public GenericResponse<Void> register(OrganizationAddressRegisterRequestDto
                                                  organizationAddressRegisterRequestDto) {
        String code = organizationAddressRegisterRequestDto.getAddressType().toString();
        String name = organizationAddressRegisterRequestDto.getAddressType().getName();


        OrganizationAddress address = organizationAddressMapper.mapToEntity(organizationAddressRegisterRequestDto);
        address.setCreatedAt(LocalDateTime.now());
        address.setActive(true);
        address.setModifiedAt(LocalDateTime.now());
        AddressType addressType = new AddressType();
        addressType.setCode(code);
        addressType.setName(name);
        addressType.setCreatedAt(LocalDateTime.now());
        addressType.setModifiedAt(LocalDateTime.now());
        addressTypeRepository.save(addressType);
        address.setAddressType(addressType);
        organizationAddressRepository.save(address);

        return GenericResponse.success("Organization Address successfully registered");
    }
}
