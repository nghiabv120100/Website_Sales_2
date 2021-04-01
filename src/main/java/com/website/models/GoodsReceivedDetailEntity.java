package com.website.models;

import javax.persistence.*;

@Entity
@Table(name = "goods_received_detail", schema = "website_sales")
@IdClass(GoodsReceivedDetailEntityPK.class)
public class GoodsReceivedDetailEntity {
    private int noteId;
    private int proId;
    private Integer quantity;

    @Id
    @Column(name = "note_id")
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    @Id
    @Column(name = "pro_id")
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsReceivedDetailEntity that = (GoodsReceivedDetailEntity) o;

        if (noteId != that.noteId) return false;
        if (proId != that.proId) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteId;
        result = 31 * result + proId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
