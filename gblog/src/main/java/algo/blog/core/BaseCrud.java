package algo.blog.core;

/**
 * 持久层基类,crud
 */
public interface BaseCrud {

    void create(Object entity);

    void update(Object entity);

    void delete(Object entity);

    void refresh(Object entity);

}
