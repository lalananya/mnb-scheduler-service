package com.mnb.shedulerservice.servcie;

import com.mnb.shedulerservice.dto.response.LoginResp;
import com.mnb.shedulerservice.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ServiceHelperClient {

    public LoginResp createClientLoginResponse(User user, String token, String message, int status) {
        LoginResp loginResp = new LoginResp();
        loginResp.setMessage(message);
        if(token.trim().isEmpty()) {
            loginResp.setStatus(status); // use correct status code later
            return loginResp;
        }
        else {
            loginResp.setStatus(status);
            loginResp.setUserToken(token);
            loginResp.setUserName(user.getUserName());
            loginResp.setUserEmail(user.getUserEmail());
            loginResp.setActiveRoles(user.getUserRole());
        }
        return loginResp;
    }

    public boolean validateClientCredentials(User user, String password) {
        return (user.getUserPassword().equals(password));
    }

}
