package az.ailab.repository;

import az.ailab.model.OrganizationAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationAddressRepository extends JpaRepository<OrganizationAddress, Long> {
}
