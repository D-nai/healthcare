package com.kaributechs.insurehub.healthcarepatientcareapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDetails {

    private String membershipNumber;

    private String firstName;

    private String lastName;

    private Gender gender;

    private String nationalID;

    private String serviceProvider;

    private Date birthDate;

    private String reasonOfVisit;

    private Date admissionDate;

    private Date dischargeDate;



}
