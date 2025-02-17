package org.example.uberprojectentityservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Builder
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Driver extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false,unique = true)
    private String licenceNumber;

    @Column(nullable = false,unique = true)
    private String aadharNumber;

    @OneToOne(mappedBy = "driver" , cascade = CascadeType.ALL)
    private Car car;

    @Enumerated(EnumType.STRING)
    private DriverApprovalStatus approvalStatus;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    private String activeCity;

    private boolean isAvailable;

    @DecimalMin(value = "0.01", message = "Rating must be greater than or equal to 0.01")
    @DecimalMax(value = "5.00",message = "Rating must be less than or equal to 5.00")
    private Double rating;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings = new ArrayList<>();
}
