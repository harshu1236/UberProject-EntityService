package org.example.uberprojectentityservice.models;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Random;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OTP extends BaseModel{
    private String code;
    private String sentToNumber;

    public static OTP make(String phoneNumber){
        OTP otp = OTP.builder().sentToNumber(phoneNumber).build();

        Random random = new Random();
        int randomInt = random.nextInt(9000) + 1000;

        otp.setCode(String.valueOf(randomInt));

        return otp;
    }
}
