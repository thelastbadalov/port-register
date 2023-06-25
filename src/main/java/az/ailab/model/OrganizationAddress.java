package az.ailab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organization_address")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationAddress extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "active")
    private Boolean active;
    @ManyToOne
    private Organization organization;

    @OneToOne
    private AddressType addressType;

}
