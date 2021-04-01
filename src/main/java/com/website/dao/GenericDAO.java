package com.website.dao;

import com.website.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import sun.net.www.content.text.Generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO<ID extends Serializable,T> {
    private Class<T> persistenceClass;

    public GenericDAO() {
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();

    }

    protected Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    public List<T> findAll() {
        List<T> list = new ArrayList<T>();
        Transaction transaction = null;
        try {
            transaction = getSession().beginTransaction();
            StringBuilder sql = new StringBuilder("from ");
            sql.append(this.getPersistenceClassName());
            Query query = this.getSession().createQuery(sql.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {

        }
        return list;
    }
}
