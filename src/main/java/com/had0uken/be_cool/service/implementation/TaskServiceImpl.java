package com.had0uken.be_cool.service.implementation;

import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;
import com.had0uken.be_cool.repository.TaskRepository;
import com.had0uken.be_cool.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> getTasksByDate(String date) {
        return taskRepository.getTasksByDate(date);
    }

    @Override
    public List<Task> getTasksByUser(User user) {
        return taskRepository.getTasksByUser(user);
    }
}
