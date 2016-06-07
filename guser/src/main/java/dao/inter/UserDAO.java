package dao.inter;

import domain.User;

public interface UserDAO {
	User getName(String username);
	String getById(int id);
}
