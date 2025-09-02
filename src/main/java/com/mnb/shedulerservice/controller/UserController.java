package com.mnb.shedulerservice.controller;

import com.mnb.shedulerservice.dto.response.CreateTaskResp;
import com.mnb.shedulerservice.dto.request.CreateTaskReq;
import com.mnb.shedulerservice.model.Task;
import com.mnb.shedulerservice.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get-users")
    public ResponseEntity<?> getUsers() throws Exception {
        return null;
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody CreateTaskReq createTask) throws Exception {
        return null;
    }

    @PutMapping("/update-user")
    public ResponseEntity updateUser() {
        return null;
    }

    @DeleteMapping("/delete-user")
    public ResponseEntity deleteUser() {
        return null;
    }
}
