package az.ailab.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Organization {
    @Id
    @GeneratedValue
    private UUID id;

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

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @OneToMany(mappedBy = "organization")
    private List<OrganizationAddress> addresses;
}
