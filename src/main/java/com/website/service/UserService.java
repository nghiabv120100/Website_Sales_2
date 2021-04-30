package com.website.service;

import com.website.dao.UserDAO;
import com.website.models.ProductEntity;
import com.website.models.UserEntity;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class UserService {
    UserDAO userDAO = new UserDAO();
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }
    public void save(UserEntity userEntity) {
        userDAO.save(userEntity);
    }
    public UserEntity update(UserEntity userEntity) {
        return userDAO.update(userEntity);
    }
    public UserEntity findById(Integer id) {
        return userDAO.findById(id);
    }

    public int delete(Integer id) {
        UserEntity userEntity = findById(id);
        userEntity.setStatus(0);
        return userDAO.delete(userEntity);
    }

}
