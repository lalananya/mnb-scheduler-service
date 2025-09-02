package com.mnb.shedulerservice.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

class UserData {

    @JsonProperty("user_email")
    String userEmail;

    @JsonProperty("user_name")
    String userName;

    @JsonProperty("active_roles")
    List<String> activeRoles;

    @JsonProperty("user_token")
    String userToken;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResp {

    @JsonProperty("user_name")
    private String message;

    @JsonProperty("user_password")
    private int status;

    @JsonProperty("user_data")
    private UserData userData;
}
