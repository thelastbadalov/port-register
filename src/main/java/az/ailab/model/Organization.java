package az.ailab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity

public class Organization extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "organization")
    private List<OrganizationAddress> addresses;
}
