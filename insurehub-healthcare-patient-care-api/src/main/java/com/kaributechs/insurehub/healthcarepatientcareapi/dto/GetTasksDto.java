package com.kaributechs.insurehub.healthcarepatientcareapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTasksDto {
    private List<TaskDto> tasks;
}