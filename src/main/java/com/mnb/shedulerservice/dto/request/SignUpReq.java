package com.mnb.shedulerservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpReq {

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("user_password")
    private String userPassword;

    @JsonProperty("user_email")
    private String userEmail;

    @JsonProperty("user_dob")
    private String userDob;
}
