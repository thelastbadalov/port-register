package az.ailab.service;

import az.ailab.dto.GeneralUserLoginRequestDto;
import az.ailab.dto.GeneralUserRegistrationRequestDto;
import az.ailab.dto.GenericResponse;
import az.ailab.exception.WrongPasswordException;
import az.ailab.mapstruct.GeneralUserMapper;
import az.ailab.model.GeneralUser;
import az.ailab.repository.GeneralUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GeneralUserService {

    private final GeneralUserRepository generalUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;



    public GenericResponse<String> login(GeneralUserLoginRequestDto generalUserLoginRequestDto) {
        GeneralUser user = generalUserRepository.findByEmail(generalUserLoginRequestDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (!passwordEncoder.matches(generalUserLoginRequestDto.getPassword(), user.getPassword())) {
            throw new WrongPasswordException("Password wrong exception");
        }
        String jwt = jwtService.generateToken(user);
        return GenericResponse.success(jwt, "SUCCESS");
    }
}
