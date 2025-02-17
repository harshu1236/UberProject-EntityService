package org.example.uberprojectentityservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DBConstant extends BaseModel{
    @Column(unique=true,nullable=false)
    private String name;

    @Column(unique=true,nullable=false)
    private String value;
}
