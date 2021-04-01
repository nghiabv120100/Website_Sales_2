package com.website.models;

import javax.persistence.*;

@Entity
@Table(name = "detail_category", schema = "website_sales")
public class DetailCategoryEntity {
    private int id;
    private String detailCateName;
    private String image;
    private Integer status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "detail_cate_name")
    public String getDetailCateName() {
        return detailCateName;
    }

    public void setDetailCateName(String detailCateName) {
        this.detailCateName = detailCateName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailCategoryEntity that = (DetailCategoryEntity) o;

        if (id != that.id) return false;
        if (detailCateName != null ? !detailCateName.equals(that.detailCateName) : that.detailCateName != null)
            return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (detailCateName != null ? detailCateName.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
