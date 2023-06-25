package az.ailab.util;

import az.ailab.dto.GeneralUserRegistrationRequestDto;
import az.ailab.exception.IncorrectData;
import az.ailab.repository.GeneralUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RegisterValidator {

    private final GeneralUserRepository publicUserRepository;

    public void validate(Object target) {
        GeneralUserRegistrationRequestDto registerRequestDto = (GeneralUserRegistrationRequestDto) target;
        if (!registerRequestDto.getEmail().equals(registerRequestDto.getConfirmedEmail())) {
            throw new IncorrectData("emails are not same");
        }
        if (!registerRequestDto.getPassword().equals(registerRequestDto.getConfirmedPassword())) {
            throw new IncorrectData("passwords are not same");
        }
    }

}
