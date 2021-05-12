package com.website.dao;

import com.website.models.ProductEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends GenericDAO<Integer, ProductEntity> {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<ProductEntity> getProductEntity (int brand_id,int detail_cate_id,int start_price, int end_price,String keyWord,int category_id,int postition, int pageSize){
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
        if (!keyWord.trim().equals("")){
            String keyword = keyWord.concat("%");
            criteria.add(Restrictions.like("proName",keyword, MatchMode.ANYWHERE));
        }
        if (category_id!= -1){
            Criteria detailcateCrit = criteria.createCriteria("detailCategoryEntity");
            detailcateCrit.createCriteria("categoryEntity").add(Restrictions.eq("id",category_id));
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

    public Long countTotalProduct_detail_category(int id){
        Session session = sessionFactory.openSession();
        String countQ = "Select count (c.id) from ProductEntity  c where c.detailCategoryEntity.id=:id";
        Query countQuery = session.createQuery(countQ);
        countQuery.setParameter("id",id);
        return (Long) countQuery.uniqueResult();
    }

    public Long countTotalProduct_brand(int id){
        Session session = sessionFactory.openSession();
        String countQ = "Select count (c.id) from ProductEntity  c where c.brandEntity.id=:id";
        Query countQuery = session.createQuery(countQ);
        countQuery.setParameter("id",id);
        return (Long) countQuery.uniqueResult();
    }

    public Long countTotalProduct_price(int start_price, int end_price){
        Session session = sessionFactory.openSession();
        String countQ = "Select count (c.id) from ProductEntity  c where c.price>=:start_price and c.price<=:end_price";
        Query countQuery = session.createQuery(countQ);
        countQuery.setParameter("start_price",start_price);
        countQuery.setParameter("end_price",end_price);
        return (Long) countQuery.uniqueResult();
    }

    public Long countTotalProduct_keyWord(String keyWord){
        Session session = sessionFactory.openSession();
        String countQ = "Select count (c.id) from ProductEntity c WHERE c.proName like concat('%',:keyWord,'%')";
        Query countQuery = session.createQuery(countQ);
        countQuery.setParameter("keyWord",keyWord);
        return (Long) countQuery.uniqueResult();
    }

    public Long countTotalProduct_cate(int id){
        Session session = sessionFactory.openSession();
        String countQ = "Select count (c.id) from ProductEntity  c where c.detailCategoryEntity.categoryEntity.id=:id";
        Query countQuery = session.createQuery(countQ);
        countQuery.setParameter("id",id);
        return (Long) countQuery.uniqueResult();
    }
}
