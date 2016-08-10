package algo.blog.service.hibernate;

import algo.blog.core.img.CateManager;
import algo.blog.core.img.ImgManager;
import algo.blog.model.BeautyPic;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.inject.Inject;
import java.util.List;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-test.xml")
public class TestImgManager {

    private ImgManager imgManager;
    private CateManager cateManager;

    @Inject
    public void setCateManager(CateManager cateManager){
        this.cateManager = cateManager;
    }

    @Inject
    public void setImgManager(ImgManager imgManager) {
        this.imgManager = imgManager;
    }

    private BeautyPic pic = null;

    public void testCreate1() {
        System.out.println("-----------------testCreate1------------");

        if (imgManager.getAll().size()==0) {
            pic = BeautyPic.defaultIntance("testImg1", "/test-path/img1.jpg", 1024 * 1024);
            imgManager.create(pic);
            cateManager.addPicToCate(pic.getPicId(),1);
        }
        Assert.isTrue(imgManager.getAll().size() > 0);
        System.out.println("--------------------end-----------------");
    }

    public void testCreate2() {
        System.out.println("----------------testCreate2--------------");
        List pics = imgManager.getPicsInCate(2);
        if (pics == null || pics.size() == 0) {
            BeautyPic pic2 = BeautyPic.defaultIntance("testImg2", "/test-path/img2.jpg", 1024 * 128);
            imgManager.create(pic2, 2);
        }
        assert imgManager.getPicsInCate(2).size() > 0;
    }

    public void testCreate3() {
        System.out.println("----------------testCreate3----------------");
        if(imgManager.getPicsInCate(1).size()<2) {
            imgManager.create("testImg3", "/test-path/img3.jpg", 1024 * 1024);
        }
        System.out.println(imgManager.getPicsInCate(1));
    }

    public void testUpdate(){
        System.out.println("----------------testUpdate-----------------");
        if(imgManager.count()>0){
            pic = (BeautyPic) imgManager.getAll().get(0);
            pic.setName("updatedImg");
            imgManager.update(pic);
            System.out.println(pic);
        }
    }


    public void testDelete(){
        System.out.println("---------------testDelete------------------");
        if(imgManager.count()>0){
            pic = imgManager.getById(1);
            imgManager.delete(pic);
        }
    }

    public void testGetPicsInCate(){
        System.out.println("---------------testGetPics-----------------");
        List<BeautyPic> pics = imgManager.getPicsInCate(1,"picId","desc");
        System.out.println(pics);
    }



}
