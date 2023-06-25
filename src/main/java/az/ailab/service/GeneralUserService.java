package az.ailab.service;

import az.ailab.constants.UserOrganizationErrorMessages;
import az.ailab.dto.GeneralUserLoginRequestDto;
import az.ailab.dto.GenericResponse;
import az.ailab.exception.UserNotFoundException;
import az.ailab.exception.WrongPasswordException;
import az.ailab.model.GeneralUser;
import az.ailab.repository.GeneralUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneralUserService {

    private final GeneralUserRepository generalUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public GenericResponse<String> login(GeneralUserLoginRequestDto generalUserLoginRequestDto) {
        GeneralUser user = generalUserRepository.findByEmail(generalUserLoginRequestDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException(UserOrganizationErrorMessages.PASSWORD_OR_EMAIL_INCORRECT));

        if (!(passwordEncoder.matches(generalUserLoginRequestDto.getPassword(), user.getPassword()))) {
            throw new WrongPasswordException(UserOrganizationErrorMessages.PASSWORD_OR_EMAIL_INCORRECT);
        }
        String jwt = jwtService.generateToken(user);
        return GenericResponse.success(jwt, "SUCCESS");
    }
}
