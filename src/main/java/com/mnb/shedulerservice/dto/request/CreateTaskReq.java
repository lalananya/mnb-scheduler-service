package com.mnb.shedulerservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTaskReq {

    @JsonProperty("task_name")
    private String taskName;

    @JsonProperty("task_description")
    private String taskDescription;

    @JsonProperty("task_detail")
    private String taskDetail; // metaDAta

    @JsonProperty("task_scheduled_for")
    private String taskScheduledFor; // time
}
