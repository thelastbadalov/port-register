package az.ailab.controller;

import az.ailab.dto.GeneralUserLoginRequestDto;
import az.ailab.dto.GeneralUserRegistrationRequestDto;
import az.ailab.dto.GenericResponse;
import az.ailab.exception.IncorrectData;
import az.ailab.service.GeneralUserService;
import az.ailab.util.RegisterValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user/")
public class GeneralUserController {

    private final GeneralUserService generalUserService;

    @PostMapping("/login")
    private GenericResponse<String> login(@Valid @RequestBody GeneralUserLoginRequestDto generalUserLoginRequestDto) {
        return generalUserService.login(generalUserLoginRequestDto);
    }



}
