package com.had0uken.be_cool.repository;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends EntityRepository<Task> {
    List<Task> getTasksByDate(String date);
    List<Task> getTasksByUser(User user);
    List<Task> getTasksByUserAndDate(User user, String date);
    List<Task> getTasksByUserAndType(User user, Type type);
    List<Task> getTasksByUserAndDateAndType(User user, String date, Type type);
    List<Task> getTasksByUserAndFrequency(User user, Frequency frequency);
    List<Task> getTasksByUserAndDateAndFrequency(User user, String date, Frequency frequency);
    List<Task> getTasksByUserAndTypeAndFrequency(User user, Type type, Frequency frequency);
    void updateTaskScore(Task task, int score);
    Task getCopy(Task task);
}
