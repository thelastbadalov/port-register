package az.ailab.util;

import az.ailab.dto.GeneralUserLoginRequestDto;
import az.ailab.dto.GeneralUserRegistrationRequestDto;
import az.ailab.repository.GeneralUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@RequiredArgsConstructor
@Component
public class RegisterValidator implements Validator {

    private final GeneralUserRepository publicUserRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return GeneralUserRegistrationRequestDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        GeneralUserRegistrationRequestDto registerRequestDto = (GeneralUserRegistrationRequestDto) target;
        if (!registerRequestDto.getEmail().equals(registerRequestDto.getConfirmedEmail())) {
            errors.rejectValue("confirmedEmail", "", "Emails have to be same");
            return;
        }
        if (!registerRequestDto.getPassword().equals(registerRequestDto.getConfirmedPassword())) {
            errors.rejectValue("confirmedPassword", "", "Passwords have to be same");
            return;
        }
        if (publicUserRepository.findByEmail(registerRequestDto.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "User with this email already exists");
        }
    }

}