package com.mnb.shedulerservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private UUID taskId;

    @Column(nullable = false, name = "task_name")
    private String taskName;

    @Column(columnDefinition = "TEXT", name = "task_description")
    private String taskDescription;

    @Column(nullable = false, name = "task_detail")
    private String taskDetail;

    @Column(nullable = false, name = "task_status")
    private String taskStatus;

    @Column(nullable = false, name = "user_id")
    private String userId;

    @Column(nullable = false, name = "task_scheduled_for")
    private String taskScheduledFor;

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

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

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskScheduledFor() {
        return taskScheduledFor;
    }

    public void setTaskScheduledFor(String taskScheduledFor) {
        this.taskScheduledFor = taskScheduledFor;
    }
}
