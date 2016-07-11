package algo.blog.core.cate;

import algo.blog.core.BaseCrud;
import algo.blog.core.BaseGeneric;
import algo.blog.model.PicCate;

import java.util.List;

/**
 *
 */
public interface CateManager extends BaseCrud,BaseGeneric<PicCate> {

    int create(String name,String comment,String cover,int mark);

    PicCate getByName(String name);


    void addPicToCate(int picId,int cateId);

    void addPicsToCate(int[] picsId,int cateId);

    void addPicToCates(int picId,int[] catesId);

    void removePicFromCate(int picId,int cateId);

    void removePicsFromCate(int[] picsId,int cateId);

    List getCatesInPic(int picId);

    List getCatesInPic(int picId, String orderBy,String order);

}
