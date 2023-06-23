package az.ailab.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrganizationAddress {

    @ManyToOne
    @JoinColumn(name = "organization_id",nullable = false)
    private Organization organization;

    @OneToMany(mappedBy = "organizationAddress")
    private List<AddressType> addressTypes;
}
