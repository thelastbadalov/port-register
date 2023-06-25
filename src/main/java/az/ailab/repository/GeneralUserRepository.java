package az.ailab.repository;

import az.ailab.model.GeneralUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneralUserRepository extends JpaRepository<GeneralUser, Long> {

    Optional<GeneralUser> findByEmail(String email);

    boolean existsByEmail(String email);

}
