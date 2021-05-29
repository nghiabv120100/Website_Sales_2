package com.website.dao;

import com.website.models.ProductEntity;
import com.website.models.Product_GoodReceived_Entity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class GoodReceivedItemDAO extends GenericDAO<Integer, Product_GoodReceived_Entity>{

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<Product_GoodReceived_Entity> productGoodReceivedEntityList (int id){
        Session session = sessionFactory.openSession();
        Criteria criteria =session.createCriteria(Product_GoodReceived_Entity.class);
        /*criteria.add(Restrictions.eq("status",1));*/
        criteria.createCriteria("goodsReceivedEntity").add(Restrictions.eq("id",id));
        return criteria.list();
    }

    public List<Product_GoodReceived_Entity> productGoodReceivedEntityList (int id_phieunhap, int id_pro, int quantity){
        Session session = sessionFactory.openSession();
        Criteria criteria =session.createCriteria(Product_GoodReceived_Entity.class);
        criteria.add(Restrictions.eq("quantity",quantity));
        criteria.createCriteria("productEntity").add(Restrictions.eq("id",id_pro));
        criteria.createCriteria("goodsReceivedEntity").add(Restrictions.eq("id",id_phieunhap));
        return criteria.list();
    }
}
