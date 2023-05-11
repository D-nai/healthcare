package com.kaributechs.insurehub.healthcarepatientcareapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "insurehub")
public class InsureHubConfig {

    String camundaUrl;

}