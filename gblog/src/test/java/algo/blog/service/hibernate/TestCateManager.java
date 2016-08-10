package algo.blog.service.hibernate;

import algo.blog.core.img.CateManager;
import algo.blog.core.img.ImgManager;
import algo.blog.model.BeautyPic;
import algo.blog.model.PicCate;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.inject.Inject;
import java.util.*;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-test.xml")
public class TestCateManager {

    private CateManager manager;

    @Inject
    public void setManager(CateManager manager) {
        this.manager = manager;
    }

    private PicCate cate = null;

    {
        cate = PicCate.defaultInstance();
        cate.setName("testCate");
        cate.setCover("/coverImgPath/test.jpg");
        cate.setComment("for test");
        cate.setMark(1);
    }

    public void testCreate1() {
        if (cate == null) {
            manager.create(cate);
        }
        Assert.notNull(manager.getByName("testCate"));
    }

    public void testCreate2() {
        PicCate obj = manager.getByName("testCate-2");
        if(obj==null) {
            String name = "testCate-2";
            String cover = "/testPath";
            int mark = 3;
            String comment = "for test";
            manager.create(name,comment,cover,mark);
        }
        Assert.notNull(obj);
    }

    public void testUpdate() {
        PicCate obj = manager.getByName("testCate");
        obj.setMark(5);
        manager.update(obj);
        System.out.println("update:"+obj);
        PicCate res = manager.getByName("testCate");
        assert res.getMark()==5;
    }

    public void testGetById() {
        int id = 1;
        PicCate obj = manager.getById(id);
        Assert.notNull(obj);
        System.out.println("GetById(" + id + "):" + obj);
    }

    public void testGetByName(){
        String name = "testCate";
        PicCate obj = manager.getByName(name);
        Assert.notNull(obj);
        System.out.println("getByName:"+obj);
    }

    public void testCount(){
        int count = manager.count();
        System.out.println("count:"+count);
        Assert.isTrue(count>1);
    }

    public void testGetAll1(){
        List<PicCate> cates = manager.getAll();
        showList(cates,"getAll");
    }

    public void testGetAll2(){
        List<PicCate> cates = manager.getAll("mark","asc");
        showList(cates,"getAll2");
    }

    public void testGetList(){
        Map<String,Object> map = new HashMap<>();
        map.put("mark",3);
        List<PicCate> cates = manager.getList(map);
        showList(cates,"getList");
    }

    public void testGetList2(){
        String hql = "from PicCate where mark=? and deleted=?";
        List<PicCate> cates = manager.getList(hql,3,false);
        showList(cates,"getList2");
    }

    private void showList(List<PicCate> list,String name){
        System.out.println("--------------"+name+"---------------");
        list.forEach(System.out::println);
        System.out.println("-----------------------------------");
        Assert.notEmpty(list);
    }

    @Inject
    private ImgManager imgManager;

    public void setImgManager(ImgManager imgManager){
        this.imgManager = imgManager;
    }

    public void testRemovePicFromCate(){
        System.out.println("--------------removePicFromCate-----------");
        BeautyPic pic = (BeautyPic) imgManager.getPicsInCate(1).get(0);
        manager.removePicFromCate(pic.getPicId(),1);
    }

    public void testAddPicToCate(){
        System.out.println("--------------addPicToCate-------------");
        BeautyPic pic = (BeautyPic) imgManager.getAll().get(0);
        manager.addPicToCate(pic.getPicId(),1);
    }

    public void testRemovePicsFromCate(){
        System.out.println("-----------removePicsFromCate-----------");
        List<BeautyPic> pics = imgManager.getPicsInCate(1);
        int[] picIds = {pics.get(0).getPicId(),pics.get(1).getPicId()};

        manager.removePicsFromCate(picIds,1);
    }

    public void testAddPicsToCate(){
        System.out.println("--------------testAddPicsToCate---------------");
        int[] picIds = imgManager.getAll().stream()
                .mapToInt(i->((BeautyPic)i).getPicId())
                .toArray();
        manager.addPicsToCate(picIds,1);
    }

    public void testGetCatesInPic(){
        System.out.println("-------------testGetCatesInPic----------------");
        BeautyPic pic = (BeautyPic) imgManager.getAll().get(1);
        List<PicCate> cates = manager.getCatesInPic(pic.getPicId(),"cateId","desc");
        System.out.println(Arrays.toString(cates.toArray()));
    }

}
