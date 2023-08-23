package com.had0uken.be_cool.repository;

import java.io.Serializable;
import java.util.List;

public interface EntityRepository<T extends Serializable> {
    T findById(Serializable id);

    void save(T entity);

    void delete(T entity);

    void update(T entity);

    void saveOrUpdate(T entity);

}
