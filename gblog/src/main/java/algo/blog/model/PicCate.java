package algo.blog.model;

import javax.persistence.*;
import java.io.Serializable;
import static javax.persistence.GenerationType.IDENTITY;
/**
 * Created by jetluo on 16/7/7.
 */
@Entity
public class PicCate implements Serializable{
    private int cateId;
    private String name;
    private String comment;
    private String cover;
    private int mark;
    private boolean deleted;
    private String cn1;

    public PicCate(){
    }

    public PicCate(String name, String comment, String cover, int mark, boolean deleted, String cn1) {
        this.name = name;
        this.comment = comment;
        this.cover = cover;
        this.mark = mark;
        this.deleted = deleted;
        this.cn1 = cn1;
    }

    public static PicCate defaultInstance(){
        PicCate cate = new PicCate();
        cate.mark = 0;
        cate.deleted = false;
        return cate;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cateId",unique = true,nullable = false)
    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 256)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "cover", nullable = false, length = 256)
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "mark", nullable = false)
    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Basic
    @Column(name = "deleted", nullable = false)
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "cn1", nullable = true, length = 256)
    public String getCn1() {
        return cn1;
    }

    public void setCn1(String cn1) {
        this.cn1 = cn1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PicCate picCate = (PicCate) o;

        if (cateId != picCate.cateId) return false;
        if (mark != picCate.mark) return false;
        if (deleted != picCate.deleted) return false;
        if (name != null ? !name.equals(picCate.name) : picCate.name != null) return false;
        if (comment != null ? !comment.equals(picCate.comment) : picCate.comment != null) return false;
        if (cover != null ? !cover.equals(picCate.cover) : picCate.cover != null) return false;
        if (cn1 != null ? !cn1.equals(picCate.cn1) : picCate.cn1 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cateId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (cover != null ? cover.hashCode() : 0);
        result = 31 * result + mark;
        result = 31 * result + (deleted ? 1 : 0);
        result = 31 * result + (cn1 != null ? cn1.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PicCate{" +
                "cateId=" + cateId +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", cover='" + cover + '\'' +
                ", mark=" + mark +
                ", deleted=" + deleted +
                ", cn1='" + cn1 + '\'' +
                '}';
    }
}
