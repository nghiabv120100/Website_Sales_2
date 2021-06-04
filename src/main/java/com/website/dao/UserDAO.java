package com.website.dao;

import com.website.models.UserEntity;
import com.website.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.HttpSession;

public class UserDAO extends GenericDAO<Integer,UserEntity> {
    public UserEntity findByUserName(String username) {
        Transaction transaction = null;
        UserEntity userEntity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            userEntity = (UserEntity) session.createQuery("FROM UserEntity U WHERE U.username = :userName").setParameter("userName", username).uniqueResult();

            if (userEntity != null ) {
                return userEntity;
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public UserEntity findbyusername_password(String username, String password){
        Transaction transaction = null;
        UserEntity userEntity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            userEntity = (UserEntity) session.createQuery("FROM UserEntity U WHERE U.username = :userName").setParameter("userName", username).uniqueResult();

            if (userEntity != null && userEntity.getPassWord().equals(password)) {
                return userEntity;
            }
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }
}
