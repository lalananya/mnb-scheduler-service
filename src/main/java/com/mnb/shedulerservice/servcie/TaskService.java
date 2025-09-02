package com.mnb.shedulerservice.servcie;

import com.mnb.shedulerservice.dto.request.CreateTaskReq;
import com.mnb.shedulerservice.model.Task;
import com.mnb.shedulerservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task createTask(CreateTaskReq createTaskReq) throws Exception {
        try{
            Task task = new Task();
            task.setTaskName(createTaskReq.getTaskName());
            task.setTaskDetail(createTaskReq.getTaskDetail());
            task.setTaskDescription(createTaskReq.getTaskDescription());
            task.setTaskScheduledFor(createTaskReq.getTaskScheduledFor());
            task.setTaskStatus("NEW");
            task.setUserId("1");
            return taskRepository.save(task);
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("");
        }
    }

    public List<Task> getTasks() throws Exception {
        try {
            return taskRepository.findAll();
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("");
        }
    }
}
