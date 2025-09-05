package com.mnb.shedulerservice.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CommonTaskDetailsResp {

    private int status = 200;
    private String message = "success";
    private List<String> typeOptions;
    private List<String> frequencyOptions;

    public List<String> getTypeOptions() {
        return typeOptions;
    }

    public void setTypeOptions(List<String> typeOptions) {
        this.typeOptions = typeOptions;
    }

    public List<String> getFrequencyOptions() {
        return frequencyOptions;
    }

    public void setFrequencyOptions(List<String> frequencyOptions) {
        this.frequencyOptions = frequencyOptions;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
