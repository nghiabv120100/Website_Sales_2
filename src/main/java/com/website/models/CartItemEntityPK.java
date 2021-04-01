package com.website.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class CartItemEntityPK implements Serializable {
    private int proId;
    private int cartId;

    @Column(name = "pro_id")
    @Id
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    @Column(name = "cart_id")
    @Id
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItemEntityPK that = (CartItemEntityPK) o;

        if (proId != that.proId) return false;
        if (cartId != that.cartId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = proId;
        result = 31 * result + cartId;
        return result;
    }
}
