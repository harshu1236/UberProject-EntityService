package org.example.uberprojectentityservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Color extends BaseModel{
    @Column(nullable = false,unique = true)
    private String colorName;

    @OneToMany(mappedBy = "color",cascade = CascadeType.ALL)
    private List<Car> cars;
}
