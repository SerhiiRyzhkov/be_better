package com.had0uken.be_cool.repository.implementation;

import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.repository.AbstractRepository;
import com.had0uken.be_cool.repository.TaskRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl extends AbstractRepository<Task> implements TaskRepository {
}
