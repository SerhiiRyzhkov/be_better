package com.had0uken.be_cool.service;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;

import java.util.List;

public interface TaskService {

    List<Task> getTasksByUser(User user);

    void save(Task task);

    List<Task> getTasksByUserAndDateAndType(User user, String date, Type type);

    List<Task> getTasksByUserAndFrequency(User user, Frequency frequency);

    List<Task> getTasksByUserAndTypeAndFrequency(User user, Type type, Frequency frequency);

    void updateTaskScore(Task task, int score);

    void delete(Task task);

    void update(Task task);

    void saveOrUpdate(Task task);

    Task getById(long id);

    Task getCopy(Task task);
}
