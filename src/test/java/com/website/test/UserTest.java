///*
//package com.website.test;
//
//import com.website.dao.UserDAO;
//import com.website.models.UserEntity;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class UserTest {
//    @Test
//    public void checkFindAll() {
//        UserDAO userDAO = new UserDAO();
//        List<UserEntity> list = userDAO.findAll();
//    }
//
//    @Test
//    public void checkUpdate() {
//        UserDAO userDAO = new UserDAO();
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(1);
//        userEntity.setFullName("Nghia");
//        UserE newEntity=  userDAO.update(userEntity);
//
//    }
//
//    @Test
//    public void checkSave() {
//        UserDAO userDAO = new UserDAO();
//
//        UserE userEntity = new UserE();
//        userEntity.setId(2);
//        userEntity.setFullName("NghiaBui");
//        userDAO.save(userEntity);
//
//    }
//
//    @Test
//    public void checkFindById() {
//        UserDAO userDAO = new UserDAO();
//
//        UserE u = userDAO.findById(1);
//
//    }
//
//    @Test
//    public void checkFindByByProperty() {
//        UserDAO userDAO = new UserDAO();
//        String property ="fullName";
//        Object value = "NghiaBui12";
//        String sortExpression ="id";
//        String sortDirection ="DESC";  //ASC|DESC
//        Object[] objects = userDAO.findByProperty(property,value,sortExpression,sortDirection);
//
//    }
//}
//*/
