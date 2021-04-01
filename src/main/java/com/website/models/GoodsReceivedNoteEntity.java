package com.website.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "goods_received_note", schema = "website_sales")
public class GoodsReceivedNoteEntity {
    private int id;
    private Date dateGoodsReceived;
    private String note;
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
    @Column(name = "date_goods_received")
    public Date getDateGoodsReceived() {
        return dateGoodsReceived;
    }

    public void setDateGoodsReceived(Date dateGoodsReceived) {
        this.dateGoodsReceived = dateGoodsReceived;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

        GoodsReceivedNoteEntity that = (GoodsReceivedNoteEntity) o;

        if (id != that.id) return false;
        if (dateGoodsReceived != null ? !dateGoodsReceived.equals(that.dateGoodsReceived) : that.dateGoodsReceived != null)
            return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateGoodsReceived != null ? dateGoodsReceived.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
