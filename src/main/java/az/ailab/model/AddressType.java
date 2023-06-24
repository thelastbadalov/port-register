package az.ailab.model;

import az.ailab.enums.AddressTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String version;
    private String name;
    private String code;

    @OneToOne(mappedBy = "addressType")
    private OrganizationAddress organizationAddress;
}
