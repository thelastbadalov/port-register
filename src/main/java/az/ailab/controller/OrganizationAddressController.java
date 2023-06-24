package az.ailab.controller;

import az.ailab.dto.GenericResponse;
import az.ailab.dto.OrganizationAddressRegisterRequestDto;
import az.ailab.service.OrganizationAddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/organization/address")
public class OrganizationAddressController {

    private final OrganizationAddressService organizationAddressService;

    @PostMapping("/register")
    public GenericResponse<Void> register(@Valid @RequestBody OrganizationAddressRegisterRequestDto
                                                      organizationAddressRegisterRequestDto){
       return organizationAddressService.register(organizationAddressRegisterRequestDto);
    }


}
