package com.website.dao;

import com.website.models.ImportGoodsEntity;
import com.website.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ImportGoodsDAO extends GenericDAO<Integer, ImportGoodsEntity>{

    public int delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ImportGoodsEntity importGoodsEntity = session.get(ImportGoodsEntity.class, id);
            if (importGoodsEntity != null) {
                session.delete(importGoodsEntity);
                return 1;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }
}
