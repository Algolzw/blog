package service.inter;

import domain.User;

public interface UserService {
	User login(String username,String password);
	User register(String username,String password);
	User anonymousLogin();
	void verify(int userId);
	void logout(int userId);
}
