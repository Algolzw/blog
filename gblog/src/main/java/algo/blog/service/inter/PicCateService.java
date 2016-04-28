package algo.blog.service.inter;

import java.util.List;

import algo.blog.model.Piccate;

public interface PicCateService {
	boolean add(String name,String comment,String cover,int mark);
	boolean update(Piccate cate);
	boolean delete(int cateId);
	Piccate getById(int cateId);
	@SuppressWarnings("rawtypes")
	List getAll();
	@SuppressWarnings("rawtypes")
	List getAll(String orderby);
	int count();
	boolean existName(String name);
	
}
