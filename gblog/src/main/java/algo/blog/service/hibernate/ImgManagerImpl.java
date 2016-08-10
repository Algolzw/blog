package algo.blog.service.hibernate;

import algo.blog.core.BaseGenericImpl;
import algo.blog.core.img.ImgManager;
import algo.blog.model.BeautyPic;
import algo.blog.model.PicInCate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

/**
 *
 */
public class ImgManagerImpl extends BaseGenericImpl<BeautyPic> implements ImgManager {

    private static final int DEFAULT_CATE_ID = 1;

    public ImgManagerImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    protected Class<BeautyPic> hookClazz() {
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
            session.flush();
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
            int id = pic.getPicId();

            PicInCate picInCate = new PicInCate(id, cateId);
            session.save(picInCate);

            trans.commit();
            session.flush();
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

                if (i % 100 == 0) {
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
            Query query = session.createSQLQuery("SELECT * FROM BeautyPic AS pic INNER JOIN PicInCate AS pinc " +
                    "ON pic.picId = pinc.picId " +
                    "WHERE pinc.cateId=? AND pic.deleted = FALSE")
                    .addEntity("BeautyPic", BeautyPic.class);
            query.setInteger(0, id);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List getPicsInCate(int id, String orderBy, String order) {
        try (Session session = session()) {
            Query query = session.createSQLQuery("SELECT * FROM beautyPic as pic inner join PicInCate as pinc " +
                    "on pic.picId = pinc.picId " +
                    "where pinc.cateId=? and pic.deleted = false " +
                    "ORDER BY pic." + orderBy + " " + order)
                    .addEntity("BeautyPic", BeautyPic.class);
            query.setInteger(0, id);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
