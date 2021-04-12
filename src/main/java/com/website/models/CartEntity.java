package com.website.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cart")
public class CartEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "status")
    private Integer status;

    //ToDo Dang lam carts

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private UserEntity shipperEntity;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private UserEntity employeeEntity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private UserEntity clientEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cartEntity")
    private List<Product_Cart_Entity> productCartEntityList;

    public CartEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UserEntity getShipperEntity() {
        return shipperEntity;
    }

    public void setShipperEntity(UserEntity shipperEntity) {
        this.shipperEntity = shipperEntity;
    }

    public UserEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(UserEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public UserEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(UserEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public List<Product_Cart_Entity> getProductCartEntityList() {
        return productCartEntityList;
    }

    public void setProductCartEntityList(List<Product_Cart_Entity> productCartEntityList) {
        this.productCartEntityList = productCartEntityList;
    }
}
