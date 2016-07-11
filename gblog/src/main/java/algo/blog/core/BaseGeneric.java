package algo.blog.core;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface BaseGeneric<E>{

    void deleteById(int id);

    E getById(int id);

    List getAll();

    List getAll(String orderBy,String order);

    List getList(Map<String,Object> conditions);

    List getList(String hql,final Object...values);

    int count();
}
