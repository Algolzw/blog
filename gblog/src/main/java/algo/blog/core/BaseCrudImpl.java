package algo.blog.core;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.util.Assert;

/**
 * 所有数据库操作类的基类,封装了一些hibernate基本方法
 * 该类和BaseGenericImpl合并,暂时已废弃
 * @param <T>
 */
@Deprecated
public abstract class BaseCrudImpl<T> implements BaseCrud {

    private SessionFactory sessionFactory;

    public BaseCrudImpl() {
    }

    public BaseCrudImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session session() {
        return sessionFactory.openSession();
    }

    @Override
    public void create(Object entity) {
        Assert.notNull(entity);
        try (Session session = session()) {
            session.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object entity) {
        Assert.notNull(entity);
        try (Session session = session()) {
            session.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void deleteById(Class<T> clazz, int id) {
        try (Session session = session()) {
            session.beginTransaction();
            T entity = session.get(clazz, id);
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object entity) {
        try (Session session = session()) {
            session.delete(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void refresh(Object entity) {
        try (Session session = session()) {
            session.refresh(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected <T> T getById(Class<T> clazz, int id) {
        try (Session session = session()) {
            return session.get(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    protected Query createQuery(String hql){
        return session().createQuery(hql);
    }

    protected Query createSqlQuery(String sql){
        return session().createSQLQuery(sql);
    }

    protected Criteria createCriteria(Class<T> clazz){
        return session().createCriteria(clazz);
    }



}
