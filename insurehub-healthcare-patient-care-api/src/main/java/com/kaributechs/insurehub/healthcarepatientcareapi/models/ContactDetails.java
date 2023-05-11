package com.kaributechs.insurehub.healthcarepatientcareapi.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data

public class ContactDetails {
    private String preferred_method_of_communication;

    private List<Object> email_addresses;

    private List<String> phone_numbers;

    private Address address_details;
}
