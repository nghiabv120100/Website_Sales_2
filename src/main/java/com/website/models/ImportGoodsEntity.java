package com.website.models;

import javax.persistence.*;

@Entity
@Table(name = "ImportGoods")
public class ImportGoodsEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nameProduct")
    private String nameProduct;

    @Column(name = "price")
    private int price;

    @Column(name = "total")
    private int total;

    @ManyToOne
    @JoinColumn(name = "goodsReceived_id")
    private GoodsReceivedEntity goodsReceivedEntity;

    public ImportGoodsEntity() {
    }

    public ImportGoodsEntity(Integer id, String nameProduct, int price, int total, GoodsReceivedEntity goodsReceivedEntity) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.total = total;
        this.goodsReceivedEntity = goodsReceivedEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public GoodsReceivedEntity getGoodsReceivedEntity() {
        return goodsReceivedEntity;
    }

    public void setGoodsReceivedEntity(GoodsReceivedEntity goodsReceivedEntity) {
        this.goodsReceivedEntity = goodsReceivedEntity;
    }
}
