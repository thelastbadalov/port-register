package az.ailab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Organization {


    @OneToMany(mappedBy = "organization")
    private List<OrganizationAddress> addresses;
}
