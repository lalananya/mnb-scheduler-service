package com.mnb.shedulerservice.controller;

import com.mnb.shedulerservice.dto.response.CreateTaskResp;
import com.mnb.shedulerservice.dto.request.CreateTaskReq;
import com.mnb.shedulerservice.model.Task;
import com.mnb.shedulerservice.servcie.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/get-task")
    public ResponseEntity<?> getTask() throws Exception {
       List<Task> allTasks = taskService.getTasks();
       try {
           if(!allTasks.isEmpty()) {
               CreateTaskResp createTaskResp = new CreateTaskResp("Task Fetched Successfully", 200,  allTasks);
               return ResponseEntity.status(HttpStatus.OK).body(createTaskResp);
           }
           else return ResponseEntity.status(HttpStatus.OK).body("No tasks found");
       }catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
       }
    }

    @PostMapping("/create-task")
    public ResponseEntity<?> createTask(@RequestBody CreateTaskReq createTask) throws Exception {
        Task createdTask = taskService.createTask(createTask);
        if(createdTask != null) {
            CreateTaskResp createTaskResp = new CreateTaskResp("Task Created Successfully", 201,  null);
            return ResponseEntity.status(HttpStatus.CREATED).body(createTaskResp);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }

    @PutMapping("/update-task")
    public ResponseEntity updateTask() {
        return null;
    }

    @DeleteMapping("/delete-task")
    public ResponseEntity deleteTask() {
        return null;
    }
}
