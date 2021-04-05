package com.website.models;

import javax.persistence.*;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "GoodsReceived")
public class GoodsReceivedEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_goods_received")
    private Date date_Goods_Received;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierEntity supplierEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "goodsReceivedEntity")
    private List<Product_GoodReceived_Entity> productGoodReceivedEntityList;

    public GoodsReceivedEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_Goods_Received() {
        return date_Goods_Received;
    }

    public void setDate_Goods_Received(Date date_Goods_Received) {
        this.date_Goods_Received = date_Goods_Received;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public SupplierEntity getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(SupplierEntity supplierEntity) {
        this.supplierEntity = supplierEntity;
    }

    public List<Product_GoodReceived_Entity> getProductGoodReceivedEntityList() {
        return productGoodReceivedEntityList;
    }

    public void setProductGoodReceivedEntityList(List<Product_GoodReceived_Entity> productGoodReceivedEntityList) {
        this.productGoodReceivedEntityList = productGoodReceivedEntityList;
    }
}