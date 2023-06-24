package az.ailab.service;

import az.ailab.dto.GenericResponse;
import az.ailab.dto.OrganizationAddressRegisterRequestDto;
import az.ailab.mapstruct.OrganizationAddressMapper;
import az.ailab.model.AddressType;
import az.ailab.model.GeneralUser;
import az.ailab.model.Organization;
import az.ailab.model.OrganizationAddress;
import az.ailab.repository.AddressTypeRepository;
import az.ailab.repository.GeneralUserRepository;
import az.ailab.repository.OrganizationAddressRepository;
import az.ailab.repository.OrganizationRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrganizationAddressService {

    private final OrganizationAddressMapper organizationAddressMapper;
    private final OrganizationAddressRepository organizationAddressRepository;
    private final AddressTypeRepository addressTypeRepository;
    private final JwtService jwtService;
    private final GeneralUserRepository userRepository;
    private final OrganizationRepository organizationRepository;

    public GenericResponse<Void> register(OrganizationAddressRegisterRequestDto
                                                  organizationAddressRegisterRequestDto, HttpServletRequest request) {

        String jwtFromRequest = jwtService.getJWTFromRequest(request);
        String email = jwtService.extractEmail(jwtFromRequest);

        GeneralUser user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("can not find user"));
        Organization organization = user.getOrganization();
        String code = organizationAddressRegisterRequestDto.getAddressType().toString();
        String name = organizationAddressRegisterRequestDto.getAddressType().getName();

        OrganizationAddress address = organizationAddressMapper.mapToEntity(organizationAddressRegisterRequestDto);
        address.setCreatedAt(LocalDateTime.now());
        address.setOrganization(organization);
        address.setActive(true);
        address.setModifiedAt(LocalDateTime.now());
        AddressType addressType = new AddressType();
        addressType.setCode(code);
        addressType.setName(name);
        addressType.setCreatedAt(LocalDateTime.now());
        addressType.setModifiedAt(LocalDateTime.now());
        addressTypeRepository.save(addressType);
        address.setAddressType(addressType);
        organizationRepository.save(organization);
        organizationAddressRepository.save(address);

        return GenericResponse.success("Organization Address successfully registered");
    }
}
