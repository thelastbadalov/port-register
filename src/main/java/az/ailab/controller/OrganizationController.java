package az.ailab.controller;

import az.ailab.dto.CommonRegisterRequestDto;
import az.ailab.dto.GenericResponse;
import az.ailab.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/organization/")
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public GenericResponse<Void> register(
            @Valid @RequestBody CommonRegisterRequestDto commonRegisterRequestDto
    ) {
        return organizationService.register(commonRegisterRequestDto);

    }
}
