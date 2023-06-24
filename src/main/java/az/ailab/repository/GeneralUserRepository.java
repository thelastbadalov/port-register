package az.ailab.repository;

import az.ailab.model.GeneralUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneralUserRepository extends JpaRepository<GeneralUser,Long> {

    Optional<GeneralUser> findByEmail(String email);
}
