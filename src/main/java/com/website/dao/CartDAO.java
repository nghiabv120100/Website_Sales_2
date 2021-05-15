package com.website.dao;

import com.website.models.CartEntity;
import com.website.models.UserEntity;
import com.website.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class CartDAO extends GenericDAO<Integer, CartEntity> {
    public List<CartEntity> findByUserId(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String sql = "From CartEntity C Where C.clientEntity.id=:id";
            Query query1 = session.createQuery(sql);
            query1.setParameter("id",id);
            List<CartEntity> lstCart = query1.list();
            transaction.commit();
            return lstCart;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
}
