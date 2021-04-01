package com.website.test;

import com.website.dao.UserDAO;
import com.website.models.UserEntity;
import org.testng.annotations.Test;

import java.util.List;

public class UserTest {
    @Test
    public void checkFindAll() {
        UserDAO userDAO = new UserDAO();
        List<UserEntity> list = userDAO.findAll();
    }
}
