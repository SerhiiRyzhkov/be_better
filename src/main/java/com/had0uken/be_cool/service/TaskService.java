package com.had0uken.be_cool.service;

import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;

import java.util.List;

public interface TaskService {
    public List<Task> getTasksByDate(String date);
    public List<Task> getTasksByUser(User user);
    public List<Task> getTasksByUserAndDate(User user, String date);
    public void save(Task task);
}
