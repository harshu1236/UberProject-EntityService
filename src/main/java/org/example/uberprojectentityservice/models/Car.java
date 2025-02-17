package org.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Car extends BaseModel{

    @Column(unique = true, nullable = false)
    private String plateNumber;

    private String brand;

    private String model;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarType carType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "color_id" , nullable = false)
    private Color color;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id" , nullable = false)
    private Driver driver;
}
