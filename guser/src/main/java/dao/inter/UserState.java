package dao.inter;

import core.UpdateState;

public interface UserState {
	
	void initState(int userId);
	void initState(int userId,String password);
	void approve(int userId);
	void loginUpdate(int userId);
	void logoutUpdate(int userId);
	
}
