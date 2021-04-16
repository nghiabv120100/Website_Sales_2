package com.website.service;

import com.website.dao.CartDAO;
import com.website.models.CartEntity;

import java.util.List;

public class CartService {
    private CartDAO cartDAO = new CartDAO();
    public List<CartEntity> findAll() {
        return cartDAO.findAll();
    }

}
