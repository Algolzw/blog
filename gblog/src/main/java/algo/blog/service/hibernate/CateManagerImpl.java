package algo.blog.service.hibernate;

import algo.blog.core.BaseGenericImpl;
import algo.blog.core.img.CateManager;
import algo.blog.model.PicCate;
import algo.blog.model.PicInCate;
import algo.blog.model.PicInCatePK;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * .
 */
public class CateManagerImpl extends BaseGenericImpl<PicCate> implements CateManager {

    public CateManagerImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    protected Class<PicCate> hookClazz() {
        return PicCate.class;
    }

    @Override
    public int create(String name, String comment, String cover, int mark) {
        Transaction trans = null;
        try (Session session = session()) {

            PicCate cate = getDefaultCate();
            cate.setName(name);
            cate.setComment(comment);
            cate.setCover(cover);
            cate.setMark(mark);

            trans = session.beginTransaction();
            session.save(cate);
            trans.commit();
            return cate.getCateId();

        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public PicCate getByName(String name) {
        try (Session session = session()) {
            Criteria criteria = session.createCriteria(PicCate.class)
                    .add(Restrictions.eq("name", name))
                    .add(Restrictions.eq("deleted", false));
            return (PicCate) criteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addPicToCate(int picId, int cateId) {
        Transaction trans = null;
        try (Session session = session()) {
            trans = session.beginTransaction();
            PicInCate pic = new PicInCate(picId, cateId);
            session.save(pic);
            trans.commit();

        } catch (Exception e) {
            if (trans != null) trans.rollback();
            e.printStackTrace();
        }
    }

    private static final int BATCH_SIZE = 50;

    @Override
    public void addPicsToCate(int[] picsId, int cateId) {
        Transaction trans = null;
        try (Session session = session()) {
            trans = session.beginTransaction();
            PicInCate pic;
            for (int i = 0; i < picsId.length; i++) {
                pic = new PicInCate(picsId[i], cateId);

                session.save(pic);

                if (i % BATCH_SIZE == 0) {
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
    public void addPicToCates(int picId, int[] catesId) {
        Transaction trans = null;
        try (Session session = session()) {
            trans = session.beginTransaction();
            PicInCate pic;
            for (int i = 0; i < catesId.length; i++) {
                pic = new PicInCate(picId, catesId[i]);

                session.save(pic);

                if (i % BATCH_SIZE == 0) {
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
    public void removePicFromCate(int picId, int cateId) {
        Transaction trans = null;
        try (Session session = session()) {
            trans = session.beginTransaction();
            PicInCatePK pk = new PicInCatePK(picId, cateId);

            PicInCate pic = session.get(PicInCate.class, pk);
            session.delete(pic);
            trans.commit();
        } catch (Exception e) {
            if (trans != null) trans.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void removePicsFromCate(int[] picsId, int cateId) {
        Transaction trans = null;
        try (Session session = session()) {
            trans = session.beginTransaction();
            PicInCate pic = null;
            PicInCatePK pk = null;
            for (int i = 0; i < picsId.length; i++) {
                pk = new PicInCatePK();
                pk.setPicId(picsId[i]);
                pk.setCateId(cateId);
                pic = session.get(PicInCate.class, pk);
                session.delete(pic);

                if (i % BATCH_SIZE == 0) {
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
    public List getCatesInPic(int picId) {
        try (Session session = session()) {
            String sql = "SELECT * FROM Piccate AS pc " +
                    "INNER JOIN PicInCate AS pic " +
                    "ON pc.cateId=pic.cateId " +
                    "WHERE pic.picId=? AND pc.deleted=FALSE";
            Query query = session.createSQLQuery(sql).addEntity(PicCate.class).setInteger(0, picId);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List getCatesInPic(int picId, String orderBy, String order) {
        try (Session session = session()) {
            String sql = "SELECT * from Piccate AS pc " +
                    "INNER JOIN PicInCate AS pic ON pc.cateId=pic.cateId " +
                    "WHERE pic.picId=? AND pc.deleted=false " +
                    "ORDER BY pc." + orderBy + " " + order;
            Query query = session.createSQLQuery(sql).addEntity(PicCate.class).setInteger(0, picId);
            return query.list();
        }
    }


    PicCate getDefaultCate() {
        return PicCate.defaultInstance();
    }
}
