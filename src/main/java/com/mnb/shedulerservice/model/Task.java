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
    @JsonProperty("task_Id")
    private UUID taskId;

    @Column(nullable = false, name = "task_name")
    @JsonProperty("task_name")
    private String taskName;

    @Column(columnDefinition = "TEXT", name = "task_description")
    @JsonProperty("task_description")
    private String taskDescription;

    @Column(nullable = false, name = "task_detail")
    @JsonProperty("task_detail")
    private String taskDetail;

    @Column(nullable = false, name = "task_status")
    @JsonProperty("task_status")
    private String taskStatus;

    @Column(nullable = false, name = "user_id")
    @JsonProperty("user_id")
    private String userId;

    @Column(nullable = false, name = "task_scheduled_for")
    @JsonProperty("task_scheduled_for")
    private String taskScheduledFor;

}
