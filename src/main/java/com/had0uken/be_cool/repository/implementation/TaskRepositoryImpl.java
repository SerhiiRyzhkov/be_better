package com.had0uken.be_cool.repository.implementation;

import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.repository.AbstractRepository;
import com.had0uken.be_cool.repository.TaskRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl extends AbstractRepository<Task> implements TaskRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    protected Session getSession() {
        return super.getSession();
    }

    @Override
    public List<Task> getTasksByDate(String date) {
        return getSession().createQuery("from Task where deadline=:deadlineParam").
                setParameter("deadlineParam",date).getResultList();
    }
}
