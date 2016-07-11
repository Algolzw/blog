package algo.blog.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jetluo on 16/7/7.
 */
public class PicInCatePK implements Serializable {
    private int picId;
    private int cateId;

    public PicInCatePK(){}

    public PicInCatePK(int picId,int cateId){
        this.picId = picId;
        this.cateId = cateId;
    }

    @Column(name = "picId", nullable = false)
    @Id
    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    @Column(name = "cateId", nullable = false)
    @Id
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

        PicInCatePK that = (PicInCatePK) o;

        if (picId != that.picId) return false;
        if (cateId != that.cateId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = picId;
        result = 31 * result + cateId;
        return result;
    }
}
