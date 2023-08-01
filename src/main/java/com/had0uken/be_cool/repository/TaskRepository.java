package com.had0uken.be_cool.repository;

import com.had0uken.be_cool.model.Task;

import java.util.List;

public interface TaskRepository extends EntityRepository<Task> {
    public List<Task> getTasksByDate(String date);
}
