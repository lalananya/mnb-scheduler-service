package com.mnb.shedulerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mnb.shedulerservice.dto.response.CommonTaskDetailsResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/heath-check")
    public ResponseEntity healthCheck() {
        return ResponseEntity.ok(200);
    }

    /**
     * setCommonTaskData({
     * typeOptions: ["User Defined", "Report Generation", "Subscriptions", "Clean DB", "Clean Caches"],
     * frequencyOptions: ["Every Day", "Every Month", "Every Year", "Custom"],
     * });
     *
     * @return
     */

    @GetMapping("/get-common-task-details")
    public CommonTaskDetailsResp getCommonTaskDetails() throws IOException {
        ObjectMapper mapper = new ObjectMapper(); // this is used to map json to DTO
        InputStream is = getClass().getResourceAsStream("/static/commonTaskDetails.json");
        return mapper.readValue(is, CommonTaskDetailsResp.class);
    }
}


