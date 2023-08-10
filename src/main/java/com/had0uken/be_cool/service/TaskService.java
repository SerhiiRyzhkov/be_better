package com.had0uken.be_cool.service;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;

import java.util.List;

public interface TaskService {
    List<Task> getTasksByDate(String date);
    List<Task> getTasksByUser(User user);
    List<Task> getTasksByUserAndDate(User user, String date);
    void save(Task task);
    List<Task> getTasksByUserAndType(User user, Type type);
    List<Task> getTasksByUserAndDateAndType(User user, String date, Type type);
    List<Task> getTasksByUserAndDateAndFrequency(User user, String date, Frequency frequency);
    List<Task> getTasksByUserAndFrequency(User user, Frequency frequency);
    List<Task> getTasksByUserAndTypeAndFrequency(User user, Type type, Frequency frequency);
    void updateTaskScore(Task task, int score);
    void delete(Task task);
    void update(Task task);
    void saveOrUpdate(Task task);
    Task getById(long id);
    Task getCopy(Task task);
}
