package com.website.service;

import com.website.dao.CartItemDAO;
import com.website.models.Product_Cart_Entity;
import com.website.models.Product_Cart_Key;

public class CartItemService {
    CartItemDAO cartItemDAO = new CartItemDAO();
    public void save(Product_Cart_Entity cartItem) {
        Product_Cart_Key product_cart_key = new Product_Cart_Key(cartItem.getProductEntity().getId(),cartItem.getCartEntity().getId());
        cartItem.setId(product_cart_key);
        cartItemDAO.save(cartItem);
    }
}
