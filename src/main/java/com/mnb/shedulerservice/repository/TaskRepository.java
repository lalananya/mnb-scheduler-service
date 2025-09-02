package com.mnb.shedulerservice.repository;

import com.mnb.shedulerservice.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> { }

/**
 * INSERT INTO tasks (task_id, task_description, task_detail, task_name, task_status)
 * VALUES (RANDOM_UUID(), 'qa.im.info@example.cn', '+1 8581234567', 'John Doe', 'Recycled');
 */