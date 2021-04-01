package com.website.models;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "website_sales")
public class ProductEntity {
    private int id;
    private String proName;
    private Integer quantity;
    private Long price;
    private String describePro;
    private String image;
    private Integer status;
    private Integer detailCateId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pro_name")
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "describe_pro")
    public String getDescribePro() {
        return describePro;
    }

    public void setDescribePro(String describePro) {
        this.describePro = describePro;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "detail_cate_id")
    public Integer getDetailCateId() {
        return detailCateId;
    }

    public void setDetailCateId(Integer detailCateId) {
        this.detailCateId = detailCateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (id != that.id) return false;
        if (proName != null ? !proName.equals(that.proName) : that.proName != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (describePro != null ? !describePro.equals(that.describePro) : that.describePro != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (detailCateId != null ? !detailCateId.equals(that.detailCateId) : that.detailCateId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (proName != null ? proName.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (describePro != null ? describePro.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (detailCateId != null ? detailCateId.hashCode() : 0);
        return result;
    }
}
