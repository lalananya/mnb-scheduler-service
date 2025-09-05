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
public class CreateTaskResp {

    private String message;
    private int status;
    private List<Task> taskData;
    private String taskScheduledFor;

    public CreateTaskResp(String message, int status, List<Task> taskData) {
        this.message = message;
        this.status = status;
        this.taskData = taskData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Task> getTaskData() {
        return taskData;
    }

    public void setTaskData(List<Task> taskData) {
        this.taskData = taskData;
    }

    public String getTaskScheduledFor() {
        return taskScheduledFor;
    }

    public void setTaskScheduledFor(String taskScheduledFor) {
        this.taskScheduledFor = taskScheduledFor;
    }
}
