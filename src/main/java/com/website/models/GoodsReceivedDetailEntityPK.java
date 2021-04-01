package com.website.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class GoodsReceivedDetailEntityPK implements Serializable {
    private int noteId;
    private int proId;

    @Column(name = "note_id")
    @Id
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    @Column(name = "pro_id")
    @Id
    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsReceivedDetailEntityPK that = (GoodsReceivedDetailEntityPK) o;

        if (noteId != that.noteId) return false;
        if (proId != that.proId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteId;
        result = 31 * result + proId;
        return result;
    }
}
