package algo.blog.service.originjdbc.inter;

import algo.blog.model.BeautyPic;

import java.util.List;

public interface ImageService {
	boolean add(String name,String urlPath,int size);
	boolean add(int cateId,String name,String urlPath,int size);
	boolean add(int cateId,String name, String urlPath,  int size, int hot, String comment, String cn1);
	
	boolean update(BeautyPic pic);
	boolean delete(int picId);
	boolean delete(int picId,boolean forever);
	BeautyPic getById(int picId);
	@SuppressWarnings("rawtypes")
	List getAll();
	@SuppressWarnings("rawtypes")
	List getAll(String orderby);
	@SuppressWarnings("rawtypes")
	List getAll(int cateId);
	@SuppressWarnings("rawtypes")
	List getAll(int cateId,String orderBy);
	int getSize();
}
