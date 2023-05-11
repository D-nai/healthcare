package com.kaributechs.insurehub.healthcarepatientcareapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data

public class HealthcareDetails {
    private List<PatientDetails> patientDetails;
    private List<DoctorDetails> doctorDetails;
    private List<ExpectedTreatmentDetails> expectedTreatmentDetails;
    private List<ContactDetails> contactDetails;
    private List<Documents> documents;

}
