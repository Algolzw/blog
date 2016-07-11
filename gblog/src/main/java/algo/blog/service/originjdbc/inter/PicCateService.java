package algo.blog.service.originjdbc.inter;

import algo.blog.model.PicCate;

import java.util.List;

public interface PicCateService {
	boolean add(String name,String comment,String cover,int mark);
	boolean update(PicCate cate);
	boolean delete(int cateId);
	PicCate getById(int cateId);
	@SuppressWarnings("rawtypes")
	List getAll();
	@SuppressWarnings("rawtypes")
	List getAll(String orderby);
	int count();
	boolean existName(String name);
	
}
