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
    private final RegisterValidator registerValidator;

    @PostMapping("/register")
    private GenericResponse<Void> registration(
            @Valid @RequestBody GeneralUserRegistrationRequestDto generalUserRegistrationRequestDto,
            BindingResult bindingResult
    ) {
        registerValidator.validate(generalUserRegistrationRequestDto, bindingResult);
        throwIncorrectDataException(bindingResult);
        generalUserService.register(generalUserRegistrationRequestDto);
        return GenericResponse.success("SUCCESS");
    }

    @PostMapping("/login")
    private GenericResponse<String> login(@Valid @RequestBody GeneralUserLoginRequestDto generalUserLoginRequestDto) {
        return generalUserService.login(generalUserLoginRequestDto);
    }

    private void throwIncorrectDataException(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer message = new StringBuffer();
            bindingResult.getFieldErrors().stream().forEach(e -> message.append(e.getField() + ":" + e.getDefaultMessage() + ", "));
            throw new IncorrectData(message.toString());
        }
    }

}
