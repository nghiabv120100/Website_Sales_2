package com.website.dao;

import com.website.models.ProductEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends GenericDAO<Integer, ProductEntity> {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<ProductEntity> getProductEntity (int postition, int pageSize){
        Session session = sessionFactory.openSession();
        Criteria criteria =session.createCriteria(ProductEntity.class);
        criteria.setFirstResult(postition);
        criteria.setMaxResults(pageSize);
        return criteria.list();
    }

    public Long countTotalProduct(){
        Session session = sessionFactory.openSession();
        String countQ = "Select count (c.id) from ProductEntity c";
        Query countQuery = session.createQuery(countQ);
        return (Long) countQuery.uniqueResult();
    }
}
