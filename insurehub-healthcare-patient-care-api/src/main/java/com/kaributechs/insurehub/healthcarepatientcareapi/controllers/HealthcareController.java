package com.kaributechs.insurehub.healthcarepatientcareapi.controllers;

import com.kaributechs.insurehub.healthcarepatientcareapi.config.InsureHubConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import com.google.gson.Gson;
import com.kaributechs.insurehub.healthcarepatientcareapi.config.InsureHubConfig;
import com.kaributechs.insurehub.healthcarepatientcareapi.dto.GetTasksDto;
import com.kaributechs.insurehub.healthcarepatientcareapi.dto.TaskDto;
import com.kaributechs.insurehub.healthcarepatientcareapi.models.HealthcareDetails;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/healthcare")
public class HealthcareController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private InsureHubConfig insureHubConfig;

    /**
     * The piece of code starts a process instance
     * */
    @PostMapping("/start")
    public Object startPreapproval(@RequestBody Object object){
        String uri = insureHubConfig.getCamundaUrl() + "/engine-rest/process-definition/key/patientcare_v1/start";
        return restTemplate.postForObject(uri, object, Object.class);
    }

    /**
     *The code completes a use task
     * */
    @PostMapping("/task/{id}/complete")
    private void completeTask(@PathVariable String id, @RequestBody Object object) throws RestClientException {
        String uri = insureHubConfig.getCamundaUrl() + "/engine-rest/task/" + id + "/complete";
        String response = restTemplate.postForObject(uri, object, String.class);
    }

    /**
     * The code returns all the user tasks
     * */
    @GetMapping("/tasks")
    private Object getAllUserTasks(){
        String uri = insureHubConfig.getCamundaUrl() + "/engine-rest/task?processDefinitionKey=patientcare_v1";
        List<TaskDto> objectsList = new ArrayList<TaskDto>();
        GetTasksDto tasksResponseDto = new GetTasksDto();
        Object[] tasks = restTemplate.getForObject(uri, Object[].class);
        List<Object> tasksList = Arrays.asList(tasks);
        JSONArray jsonArray = new JSONArray(tasksList);
        Gson gson = new Gson();

        for (int i=0; i < jsonArray.length(); i++) {
            TaskDto taskDto = new TaskDto();
            Object task = gson.fromJson(jsonArray.getJSONObject(i).toString(), Object.class);
            taskDto.setTask(task);

            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String processInstanceId = jsonObject.getString("processInstanceId");

            String exceptionName = insureHubConfig.getCamundaUrl() + "/engine-rest/process-instance/" + processInstanceId + "/variables/healthcareInfo";
            String healthcareInfoObj = restTemplate.getForObject(exceptionName, String.class);
            JSONObject healthcareInfoJson = new JSONObject(healthcareInfoObj);
            taskDto.setHealthcareInfo(healthcareInfoJson);

            objectsList.add(taskDto);
        }



        return objectsList;
    }

    /*
     * The code returns user variables
     * */
    @GetMapping("/{processId}/variables")
    private Object getTaskVariables(@PathVariable String processId) {
        String uri = insureHubConfig.getCamundaUrl() + "/engine-rest/process-instance/" + processId + "/variables/healthcareInfo";
        return restTemplate.getForObject(uri, Object.class);
    }


    /**
     * The code assigns the user tasks
     */
    @PostMapping("/tasks/{id}/assign")
    private String assignConsultant(@PathVariable String id,@RequestBody Object object) {
        String uri = insureHubConfig.getCamundaUrl() + "/engine-rest/task/" + id + "/assignee";
        return restTemplate.postForObject(uri, object, String.class);
    }


}
