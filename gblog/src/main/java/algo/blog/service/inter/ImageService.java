package algo.blog.service.inter;

import java.util.List;

import algo.blog.model.Beautypic;

public interface ImageService {
	boolean add(String name,String urlPath,int size);
	boolean add(int cateId,String name,String urlPath,int size);
	boolean add(int cateId,String name, String urlPath,  int size, int hot, String comment, String cn1);
	
	boolean update(Beautypic pic);
	boolean delete(int picId);
	boolean delete(int picId,boolean forever);
	Beautypic getById(int picId);
	@SuppressWarnings("rawtypes")
	List getAll();
	@SuppressWarnings("rawtypes")
	List getAll(String orderby);
	@SuppressWarnings("rawtypes")
	List getAll(int cateId);
	@SuppressWarnings("rawtypes")
	List getAll(int cateId,String orderby);
	int getSize();
}
