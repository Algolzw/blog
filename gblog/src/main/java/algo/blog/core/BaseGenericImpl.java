package algo.blog.core;

import algo.blog.core.exception.NotImplException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 */
public abstract class BaseGenericImpl<E> implements BaseCrud,BaseGeneric<E> {

    //hibernate sessionFactory,从spring配置文件注入
    private SessionFactory sessionFactory;

    //范型真实的类,需要子类覆写hookClazz方法
    protected Class<E> clazz;

    public BaseGenericImpl() {
    }

    public BaseGenericImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session session() {
        return sessionFactory.openSession();
    }

    /**
     * 初始化类clazz
     *
     * @throws Exception
     */
    public void init() throws Exception {
        this.clazz = hookClazz();
    }

    //钩子方法,子类必须覆写
    protected Class<E> hookClazz() throws Exception {
        throw new NotImplException();
    }

    /**
     *
     * @param entity
     */
    @Override
    public void create(Object entity) {
        Assert.notNull(entity);
        try (Session session = session()) {
            session.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param entity
     */
    @Override
    public void update(Object entity) {
        Assert.notNull(entity);
        try (Session session = session()) {
            session.update(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void deleteById(Class<E> clazz, Serializable id) {
        try (Session session = session()) {
            session.beginTransaction();
            E entity = session.get(clazz, id);
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param entity
     */
    @Override
    public void delete(Object entity) {
        try (Session session = session()) {
            session.delete(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param entity
     */
    @Override
    public void refresh(Object entity) {
        try (Session session = session()) {
            session.refresh(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected <T> T getById(Class<T> clazz, Serializable id) {
        try (Session session = session()) {
            return session.get(clazz, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //hql查询语句
    protected Query createQuery(String hql){
        return session().createQuery(hql);
    }

    //原生sql 查询
    protected Query createSqlQuery(String sql){
        return session().createSQLQuery(sql);
    }

    //criteria查询
    protected Criteria createCriteria(Class<E> clazz){
        return session().createCriteria(clazz);
    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteById(int id) {
        deleteById(clazz, id);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public E getById(int id) {
        return getById(clazz, id);
    }

    /**
     *
     * @return
     */
    @Override
    public List getAll() {
        return createCriteria(clazz).add(Restrictions.eq("deleted", false)).list();
    }

    /**
     *
     * @param orderBy
     * @param order
     * @return
     */
    @Override
    public List getAll(String orderBy, String order) {
        Criteria criteria = createCriteria(clazz)
                .add(Restrictions.eq("deleted", false))
                .addOrder(
                        "asc".equalsIgnoreCase(order)?
                                Order.asc(orderBy)
                                : Order.desc(orderBy)
                );

        return criteria.list();
    }

    /**
     *
     * @param conditions
     * @return
     */
    @Override
    public List getList(Map<String, Object> conditions) {
        if(conditions==null || conditions.isEmpty()) return getAll();

        Criteria criteria = createCriteria(clazz).add(Restrictions.eq("deleted", false));
        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
        }
        return criteria.list();
    }

    /**
     *
     * @param hql
     * @param values
     * @return
     */
    public List getList(String hql, final Object... values) {
        Query query = session().createQuery(hql);
        if(values == null) return query.list();

        for (int i = 0; i < values.length; i++) {
            query.setParameter(i, values[i]);
        }
        return query.list();
    }

    /**
     *
     * @return
     */
    @Override
    public int count(){
        return (Integer) session().createCriteria(clazz)
                .add(Restrictions.eq("deleted",false))
                .setProjection(Projections.rowCount())
                .uniqueResult();

    }
}
