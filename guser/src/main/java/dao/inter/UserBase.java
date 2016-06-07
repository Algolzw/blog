package dao.inter;

import domain.User;

public interface UserBase {
	User validateUser(String username,String password);
	boolean exist(String username);
	User create(String username);
	User create(String username,boolean anonymous);
	User findById(int userId);
	User findByName(String username);
}
