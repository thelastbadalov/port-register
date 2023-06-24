package az.ailab.service;

import az.ailab.repository.GeneralUserRepository;
import az.ailab.util.UserPrincipal;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final GeneralUserRepository generalUserRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) {
        return new UserPrincipal(generalUserRepository.findByEmail(username).orElseThrow(() -> new
                UsernameNotFoundException("can not find username")));
    }

}
