package com.had0uken.be_cool.repository.implementation;

import com.had0uken.be_cool.enums.Frequency;
import com.had0uken.be_cool.enums.Type;
import com.had0uken.be_cool.model.Task;
import com.had0uken.be_cool.model.User;
import com.had0uken.be_cool.repository.AbstractRepository;
import com.had0uken.be_cool.repository.TaskRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryImpl extends AbstractRepository<Task> implements TaskRepository {

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

    @Override
    public List<Task> getTasksByUserAndType(User user, Type type) {
        return getSession().createQuery("from Task where user_email=:emailParam and type=:typeParam").
                setParameter("emailParam",user.getEmail()).setParameter("typeParam",type).getResultList();
    }

    @Override
    public List<Task> getTasksByUserAndDateAndType(User user, String date, Type type) {
        return getSession().createQuery("from Task where user_email=:emailParam and type=:typeParam and deadline=:dateParam").
                setParameter("emailParam",user.getEmail()).setParameter("typeParam",type).setParameter("dateParam",date).getResultList();
    }

    @Override
    public List<Task> getTasksByUserAndFrequency(User user, Frequency frequency) {
        return getSession().createQuery("from Task where user_email=:emailParam and frequency=:frequencyParam").
                setParameter("emailParam",user.getEmail()).setParameter("frequencyParam",frequency).getResultList();
    }

    @Override
    public List<Task> getTasksByUserAndDateAndFrequency(User user, String date, Frequency frequency) {
        return getSession().createQuery("from Task where user_email=:emailParam and frequency=:frequencyParam and deadline=:dateParam").
                setParameter("emailParam",user.getEmail()).setParameter("frequencyParam",frequency).setParameter("dateParam",date).getResultList();
    }

    @Override
    public List<Task> getTasksByUserAndTypeAndFrequency(User user, Type type, Frequency frequency) {
        return getSession().createQuery("from Task where user_email=:emailParam and frequency=:frequencyParam and type=:typeParam").
                setParameter("emailParam",user.getEmail()).setParameter("frequencyParam",frequency).setParameter("typeParam",type).getResultList();
    }

}
