package com.had0uken.be_cool.repository;

import java.io.Serializable;

public interface EntityRepository <T extends Serializable> {
    T findById(Serializable id);
}
