package com.mnb.shedulerservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mnb.shedulerservice.model.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskResp {

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private int status;

    @JsonProperty("task-data")
    private List<Task> taskData;

}
