package az.ailab.service;

import az.ailab.dto.OrganizationRegisterRequestDto;
import az.ailab.exception.UserNotFoundException;
import az.ailab.mapstruct.OrganizationMapper;
import az.ailab.model.GeneralUser;
import az.ailab.model.Organization;
import az.ailab.repository.GeneralUserRepository;
import az.ailab.repository.OrganizationRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final GeneralUserRepository generalUserRepository;
    private final JwtService jwtService;
    private final OrganizationMapper organizationMapper;
    public void register(OrganizationRegisterRequestDto organizationRegisterRequestDto, HttpServletRequest servletRequest){
        String token = jwtService.getJWTFromRequest(servletRequest);
        String email = jwtService.extractEmail(token);
        GeneralUser user = generalUserRepository.findByEmail(email).orElseThrow(()->new UserNotFoundException("user with this email not found"));
        Organization organization = organizationMapper.mapToEntity(organizationRegisterRequestDto);
        organization.setCreatedAt(LocalDateTime.now());
        organization.setActive(true);
        organization.setModifiedAt(LocalDateTime.now());
        organization.setCreatedBy(null);
        organization.setModifiedBy(null);
        organizationRepository.save(organization);
        user.setOrganization(organization);
        generalUserRepository.save(user);
    }

}
