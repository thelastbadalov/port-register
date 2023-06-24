package az.ailab.repository;

import az.ailab.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    boolean existsByTaxIdentificationNumber(String taxIden);
}
