package com.mnb.shedulerservice.servcie;

import com.mnb.shedulerservice.dto.request.SignUpReq;
import com.mnb.shedulerservice.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceHelperDB {

    public User parseSignUpResponse(SignUpReq signUpReq) {
        User user = new User();
        user.setUserDob(signUpReq.getUserDob());
        user.setUserRole("USER");
        user.setUserPassword(signUpReq.getUserPassword());
        user.setUserEmail(signUpReq.getUserEmail());
        user.setUserName(signUpReq.getUserName());
        return user;
    }
}
