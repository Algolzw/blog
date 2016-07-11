package algo.blog.model;

import utility.DateUtil;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Entity
public class BeautyPic implements Serializable{
    private int picId;
    private String name;
    private String urlPath;
    private Date uploadTime;
    private int size;
    private int hot;
    private String comment;
    private boolean deleted;
    private String cn1;

    public static BeautyPic defaultIntance(){
        BeautyPic pic = new BeautyPic();
        pic.name = "";
        pic.urlPath = "";
        pic.uploadTime = DateUtil.getCurrentDate();
        pic.size = 0;
        pic.hot = 0;
        pic.deleted = false;

        return pic;
    }

    public static BeautyPic defaultIntance(String name,String urlPath,int size){
        BeautyPic pic = new BeautyPic();
        pic.name = name;
        pic.urlPath = urlPath;
        pic.uploadTime = DateUtil.getCurrentDate();
        pic.size = size;
        pic.hot = 0;
        pic.deleted = false;

        return pic;
    }

    @Id
    @Column(name = "picId", nullable = false)
    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "urlPath", nullable = false, length = 256)
    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    @Basic
    @Column(name = "uploadTime", nullable = false)
    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Basic
    @Column(name = "size", nullable = false)
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Basic
    @Column(name = "hot", nullable = false)
    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

        BeautyPic beautyPic = (BeautyPic) o;

        if (picId != beautyPic.picId) return false;
        if (size != beautyPic.size) return false;
        if (hot != beautyPic.hot) return false;
        if (deleted != beautyPic.deleted) return false;
        if (name != null ? !name.equals(beautyPic.name) : beautyPic.name != null) return false;
        if (urlPath != null ? !urlPath.equals(beautyPic.urlPath) : beautyPic.urlPath != null) return false;
        if (uploadTime != null ? !uploadTime.equals(beautyPic.uploadTime) : beautyPic.uploadTime != null) return false;
        if (comment != null ? !comment.equals(beautyPic.comment) : beautyPic.comment != null) return false;
        if (cn1 != null ? !cn1.equals(beautyPic.cn1) : beautyPic.cn1 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = picId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (urlPath != null ? urlPath.hashCode() : 0);
        result = 31 * result + (uploadTime != null ? uploadTime.hashCode() : 0);
        result = 31 * result + size;
        result = 31 * result + hot;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (deleted ? 1 : 0);
        result = 31 * result + (cn1 != null ? cn1.hashCode() : 0);
        return result;
    }
}
