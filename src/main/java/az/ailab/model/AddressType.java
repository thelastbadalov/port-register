package az.ailab.model;

import jakarta.persistence.*;

@Entity
public class AddressType {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "organization_address_id",nullable = false)
    private OrganizationAddress organizationAddress;
}
