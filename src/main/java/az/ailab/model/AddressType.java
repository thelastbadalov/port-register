package az.ailab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AddressType {

    @ManyToOne
    @JoinColumn(name = "organization_address_id",nullable = false)
    private OrganizationAddress organizationAddress;
}
