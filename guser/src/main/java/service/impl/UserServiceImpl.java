package service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import dao.inter.UserBase;
import dao.inter.UserState;
import domain.User;
import service.inter.UserService;
import utils.DateUtils;

@Service
public class UserServiceImpl implements UserService {

	private UserBase userBase;
	private UserState userState;
	
	
	@Inject
	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}

	@Inject
	public void setUserState(UserState userState) {
		this.userState = userState;
	}

	@Override
	public User login(String username, String password) {
		User user = userBase.validateUser(username, password);
		if(user!=null)
			userState.loginUpdate(user.getUserId());
		return user;
	}

	@Override
	public User register(String username, String password) {
		User user = userBase.create(username);
		if(user!=null)
			userState.initState(user.getUserId(), password);
		return user;
	}

	@Override
	public User anonymousLogin() {
		User user = userBase.create(DateUtils.getUniqueName());
		return user;
	}

	@Override
	public void verify(int userId) {
		this.userState.approve(userId);
	}

	@Override
	public void logout(int userId) {
		this.userState.logoutUpdate(userId);
	}

}
