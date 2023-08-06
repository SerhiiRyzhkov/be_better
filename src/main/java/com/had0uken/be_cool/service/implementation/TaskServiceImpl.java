package com.had0uken.be_cool.service.implementation;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Type;
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

    @Override
    public List<Task> getTasksByUserAndDate(User user, String date) {
        return taskRepository.getTasksByUserAndDate(user,date);
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByUserAndType(User user, Type type) {
        return taskRepository.getTasksByUserAndType(user,type);
    }

    @Override
    public List<Task> getTasksByUserAndDateAndType(User user, String date, Type type) {
        return taskRepository.getTasksByUserAndDateAndType(user,date,type);
    }

    @Override
    public List<Task> getTasksByUserAndDateAndFrequency(User user, String date, Frequency frequency) {
        return taskRepository.getTasksByUserAndDateAndFrequency(user,date,frequency);
    }

    @Override
    public List<Task> getTasksByUserAndFrequency(User user, Frequency frequency) {
        return taskRepository.getTasksByUserAndFrequency(user,frequency);
    }

    @Override
    public List<Task> getTasksByUserAndTypeAndFrequency(User user, Type type, Frequency frequency) {
        return taskRepository.getTasksByUserAndTypeAndFrequency(user,type,frequency);
    }

    @Override
    public void updateTaskScore(Task task, int score) {
        taskRepository.updateTaskScore(task,score);
    }
}
