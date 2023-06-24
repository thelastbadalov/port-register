package az.ailab.service;

import az.ailab.dto.CommonRegisterRequestDto;
import az.ailab.dto.GenericResponse;
import az.ailab.exception.OrganizationOrUserAlreadyExists;
import az.ailab.mapstruct.GeneralUserMapper;
import az.ailab.mapstruct.OrganizationAddressMapper;
import az.ailab.mapstruct.OrganizationMapper;
import az.ailab.model.AddressType;
import az.ailab.model.GeneralUser;
import az.ailab.model.Organization;
import az.ailab.model.OrganizationAddress;
import az.ailab.repository.AddressTypeRepository;
import az.ailab.repository.GeneralUserRepository;
import az.ailab.repository.OrganizationAddressRepository;
import az.ailab.repository.OrganizationRepository;
import az.ailab.util.RegisterValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final GeneralUserRepository generalUserRepository;
    private final OrganizationMapper organizationMapper;
    private final GeneralUserMapper generalUserMapper;
    private final OrganizationAddressMapper organizationAddressMapper;
    private final OrganizationAddressRepository organizationAddressRepository;
    private final RegisterValidator registerValidator;
    private final OrganizationAddressService organizationAddressService;
    private final AddressTypeRepository addressTypeRepository;

    public GenericResponse<Void> register(CommonRegisterRequestDto commonRegisterRequestDto){
        
        Organization organization =
                organizationMapper.mapToEntity(commonRegisterRequestDto.getOrganizationRegisterRequestDto());

        registerValidator.validate(commonRegisterRequestDto.getUserRegistrationRequestDto());

        GeneralUser generalUser =
                generalUserMapper.mapToEntity(commonRegisterRequestDto.getUserRegistrationRequestDto());

        OrganizationAddress organizationAddress =
                organizationAddressMapper.mapToEntity(commonRegisterRequestDto.getOrganizationAddressRegisterRequestDto());

        AddressType addressType =
                organizationAddressService.createAddressType(commonRegisterRequestDto.getOrganizationAddressRegisterRequestDto());

        if(organizationRepository.existsByTaxIdentificationNumber(organization.getTaxIdentificationNumber()) ||
                generalUserRepository.existsByEmail(generalUser.getEmail())){
            throw new OrganizationOrUserAlreadyExists("organization or user already exists");
        }

        organizationAddress.setOrganization(organization);

        generalUser.setOrganization(organization);
        organizationAddress.setAddressType(addressType);
        addressTypeRepository.save(addressType);
        organizationRepository.save(organization);
        generalUserRepository.save(generalUser);
        organizationAddressRepository.save(organizationAddress);

        return GenericResponse.success("SUCCESS");

    }

}
