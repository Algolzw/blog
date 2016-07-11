package algo.blog.service.hibernate;

import algo.blog.core.BaseGenericImpl;
import algo.blog.core.img.ImgManager;
import algo.blog.model.BeautyPic;
import algo.blog.model.PicInCate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 *
 */
public class ImgManagerImpl extends BaseGenericImpl<BeautyPic> implements ImgManager {

    private static final int DEFAULT_CATE_ID = 1;

    public ImgManagerImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @Override
    protected Class<BeautyPic> hookClazz(){
        return BeautyPic.class;
    }

    @Override
    public void create(String name, String urlPath, int size) {
        Transaction trans = null;
        try (Session session = session()) {
            trans = session.beginTransaction();

            BeautyPic pic = BeautyPic.defaultIntance(name, urlPath, size);
            session.save(pic);

            PicInCate picInCate = new PicInCate(pic.getPicId(), DEFAULT_CATE_ID);
            session.save(picInCate);

            trans.commit();
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void create(BeautyPic pic, int cateId) {
        Transaction trans = null;
        try (Session session = session()) {
            trans = session.beginTransaction();

            session.save(pic);

            PicInCate picInCate = new PicInCate(pic.getPicId(), cateId);
            session.save(picInCate);

            trans.commit();
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void create(BeautyPic[] pics, int cateId) {
        Transaction trans = null;
        try (Session session = session()) {
            trans = session.beginTransaction();

            for (int i = 0; i < pics.length; i++) {
                session.save(pics[i]);

                PicInCate picInCate = new PicInCate(pics[i].getPicId(), cateId);
                session.save(picInCate);

                if(i%100==0){
                    session.flush();
                    session.clear();
                }
            }
            trans.commit();
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List getPicsInCate(int id) {
        try (Session session = session()) {
            return session.createCriteria(BeautyPic.class, "bp")
                    .createAlias("picInCate", "pc")
                    .add(Restrictions.eqProperty("bp.picId", "pc.picId"))
                    .add(Restrictions.eq("pc.cateId", id))
                    .add(Restrictions.eq("bp.deleted", false))
                    .addOrder(org.hibernate.criterion.Order.desc("uploadTime"))
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List getPicsInCate(int id, String orderBy, String order) {
        try (Session session = session()) {
            return session.createCriteria(BeautyPic.class, "bp")
                    .createAlias("picInCate", "pc")
                    .add(Restrictions.eqProperty("bp.picId", "pc.picId"))
                    .add(Restrictions.eq("pc.cateId", id))
                    .add(Restrictions.eq("bp.deleted", false))
                    .addOrder("asc".equalsIgnoreCase(order) ?
                            Order.asc(orderBy)
                            : Order.desc(orderBy)
                    ).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
