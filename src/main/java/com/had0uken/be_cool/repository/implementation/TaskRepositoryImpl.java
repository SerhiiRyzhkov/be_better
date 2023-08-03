package com.had0uken.be_cool.repository.implementation;

import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;
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

    @Override
    public List<Task> getTasksByUser(User user) {
        return getSession().createQuery("from Task where user_email=:emailParam").
                setParameter("emailParam",user.getEmail()).getResultList();
    }

    @Override
    public List<Task> getTasksByUserAndDate(User user, String date) {
        return getSession().createQuery("from Task where user_email=:emailParam and deadline=:dateParam").
                setParameter("emailParam",user.getEmail()).setParameter("dateParam",date).getResultList();
    }

}
