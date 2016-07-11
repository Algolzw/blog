package algo.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * Created by jetluo on 16/7/7.
 */
@Entity
@IdClass(PicInCatePK.class)
public class PicInCate implements Serializable {
    private int picId;
    private int cateId;

    public PicInCate(){
    }

    public PicInCate(int picId,int cateId){
        this.picId = picId;
        this.cateId = cateId;
    }

    @Id
    @Column(name = "picId", nullable = false)
    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    @Id
    @Column(name = "cateId", nullable = false)
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PicInCate picInCate = (PicInCate) o;

        if (picId != picInCate.picId) return false;
        if (cateId != picInCate.cateId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = picId;
        result = 31 * result + cateId;
        return result;
    }
}
