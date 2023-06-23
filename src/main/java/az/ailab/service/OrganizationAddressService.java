package az.ailab.service;

import az.ailab.repository.OrganizationAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationAddressService {

    private final OrganizationAddressRepository organizationAddressRepository;



}
