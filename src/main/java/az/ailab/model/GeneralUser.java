package az.ailab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class GeneralUser {
    @Id
    @GeneratedValue
    private Long id;
}
