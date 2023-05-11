package com.kaributechs.insurehub.healthcarepatientcareapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TaskDto {
    private Object task;
    private JSONObject healthcareInfo;
}