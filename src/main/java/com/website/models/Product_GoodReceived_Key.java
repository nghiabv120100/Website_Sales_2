package com.website.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Product_GoodReceived_Key implements Serializable {

    @Column(name = "goodsreceived_id")
    private Long goodsreceived_id;

    @Column(name = "pro_id")
    private Long pro_id;

    public Product_GoodReceived_Key() {
    }

    public Product_GoodReceived_Key(Long goodsreceived_id, Long pro_id) {
        this.goodsreceived_id = goodsreceived_id;
        this.pro_id = pro_id;
    }

    public Long getGoodsreceived_id() {
        return goodsreceived_id;
    }

    public void setGoodsreceived_id(Long goodsreceived_id) {
        this.goodsreceived_id = goodsreceived_id;
    }

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product_GoodReceived_Key)) return false;
        Product_GoodReceived_Key that = (Product_GoodReceived_Key) o;
        return getGoodsreceived_id().equals(that.getGoodsreceived_id()) && getPro_id().equals(that.getPro_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGoodsreceived_id(), getPro_id());
    }
}
