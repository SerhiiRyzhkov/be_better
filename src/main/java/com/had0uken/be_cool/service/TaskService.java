package com.had0uken.be_cool.service;

import com.had0uken.be_cool.model.Task;

import java.util.List;

public interface TaskService {
    public List<Task> getTasksByDate(String date);
}
