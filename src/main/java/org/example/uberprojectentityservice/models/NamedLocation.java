package org.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NamedLocation extends BaseModel{

    @OneToOne
    @JoinColumn(name = "exact_location_id", unique = true)
    private ExactLocation exactLocation;

    private String name;

    private String zipCode;

    private String city;

    private String state;

    private String country;
}
