package com.kaributechs.insurehub.healthcarepatientcareapi.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExpectedTreatmentDetails {
    private List<Object> treatment_details;

    private String diagnosis;

    private List<Object> medical_history_details;
}
