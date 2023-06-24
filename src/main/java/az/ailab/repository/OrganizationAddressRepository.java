package az.ailab.repository;

import az.ailab.model.OrganizationAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrganizationAddressRepository extends JpaRepository<OrganizationAddress, Long> {
}
