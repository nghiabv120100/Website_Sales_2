package com.website.service;

import com.website.dao.CartDAO;
import com.website.models.CartEntity;

import java.util.List;

public class CartService {
    private CartDAO cartDAO = new CartDAO();
    public List<CartEntity> findAll() {
        return cartDAO.findAll();
    }
    public CartEntity findById(Integer id) {
        return cartDAO.findById(id);
    }
    public CartEntity update(CartEntity cart) {
        return cartDAO.update(cart);
    }
    public int delete(Integer id) {
        CartEntity cart = findById(id);
        cart.setStatus(0);
        return cartDAO.delete(cart);
    }

}
