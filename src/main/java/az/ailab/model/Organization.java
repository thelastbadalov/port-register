package az.ailab.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Organization extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "organization_code")
    private String organizationCode;

    @Column(name = "organization_name")
    private String organizationName;

    @Column(name = "tax_identification_number")
    private String taxIdentificationNumber;

    @Column(name = "email_address")
    private String email_address;

    @Column(name = "organization_phone_number")
    private String organizationPhoneNumber;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<GeneralUser> generalUsers;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<OrganizationAddress> addresses;

    @Column(name = "active")
    private Boolean active;
}
