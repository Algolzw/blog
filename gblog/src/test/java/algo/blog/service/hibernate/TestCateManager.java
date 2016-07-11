package algo.blog.service.hibernate;

import algo.blog.core.cate.CateManager;
import algo.blog.model.PicCate;

import javax.inject.Inject;

/**
 *
 */
public class TestCateManager {

    private CateManager manager;

    @Inject
    public void setManager(CateManager manager){
        this.manager = manager;
    }


    public void testCreate1(){
        PicCate cate = PicCate.defaultInstance();
        cate.setName("testCate");
        cate.setCover("/coverImgPath/test.jpg");
        cate.setComment("for test");
        cate.setMark(1);
        manager.create(cate);
    }



}
