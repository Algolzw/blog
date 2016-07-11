package algo.blog.core.img;

import algo.blog.core.BaseCrud;
import algo.blog.core.BaseGeneric;
import algo.blog.model.BeautyPic;

import java.util.List;

/**
 *
 */
public interface ImgManager extends BaseCrud,BaseGeneric<BeautyPic> {

    void create(String name,String urlPath,int size);

    void create(BeautyPic pic,int cateId);

    void create(BeautyPic[] pics,int cateId);

    List getPicsInCate(int id);

    List getPicsInCate(int id,String orderBy,String order);


}
