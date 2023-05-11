package com.kaributechs.insurehub.healthcarepatientcareapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorDetails {

    private String firstName;

    private String lastName;

    private String nationalID;

    private String specialty;

    private String hospitalName;

    private String doctorID;

}
