package com.mnb.shedulerservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTaskReq {

    private String taskName;
    private String taskDescription;
    private String taskDetail; // metaDAta
    private String taskScheduledFor; // time

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public String getTaskScheduledFor() {
        return taskScheduledFor;
    }

    public void setTaskScheduledFor(String taskScheduledFor) {
        this.taskScheduledFor = taskScheduledFor;
    }
}
