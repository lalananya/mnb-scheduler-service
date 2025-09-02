package com.mnb.shedulerservice.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResp {

    @JsonProperty("user_name")
    private String message;

    @JsonProperty("user_password")
    private int status;

    @JsonProperty("user_token")
    String userToken;

    @JsonProperty("user_email")
    String userEmail;

    @JsonProperty("user_name")
    String userName;

    @JsonProperty("active_roles")
    List<String> activeRoles;
}
