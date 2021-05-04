package com.website.dao;

import com.website.models.ProductEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends GenericDAO<Integer, ProductEntity> {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<ProductEntity> getProductEntity (int brand_id,int detail_cate_id,int start_price, int end_price,int postition, int pageSize){
        Session session = sessionFactory.openSession();
        Criteria criteria =session.createCriteria(ProductEntity.class);

        if (detail_cate_id != -1){
            criteria.createCriteria("detailCategoryEntity").add(Restrictions.eq("id",detail_cate_id));
        }
        if (start_price != -1 && end_price != 900000000){
            criteria.add(Restrictions.between("price", start_price, end_price));
        }
        if (brand_id != -1){
            criteria.createCriteria("brandEntity").add(Restrictions.eq("id",brand_id));
        }
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
