package dao.impl;

import java.util.Date;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import dao.inter.UserState;
import domain.Userstate;

@Component
public class UserStateImpl implements UserState {

	private SessionFactory sessionFactory;
	
	@Inject
	public UserStateImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void initState(int userId) {
		Session session = this.sessionFactory.openSession();
		Userstate state = new Userstate();
		state.setUserId(userId);
		session.save(state);
		session.disconnect();
	}
	
	@Override
	public void initState(int userId,String password) {
		Session session = this.sessionFactory.openSession();
		Userstate state = new Userstate();
		state.setUserId(userId);
		state.setPassword(password);
		session.save(state);
		session.disconnect();
	}

	@Override
	public void approve(int userId) {
		Session session = this.sessionFactory.openSession();
		Userstate state = (Userstate)session.get(Userstate.class, userId);
		state.setApproved(true);
		session.update(state);
		session.disconnect();
	}

	@Override
	public void loginUpdate(int userId) {
		Session session = this.sessionFactory.openSession();
		Userstate state = (Userstate)session.get(Userstate.class, userId);
		state.setOnline(true);
		state.setLastLoginTime(new Date());
		session.update(state);
		session.disconnect();
	}

	@Override
	public void logoutUpdate(int userId) {
		Session session = this.sessionFactory.openSession();
		Userstate state = (Userstate)session.get(Userstate.class, userId);
		state.setOnline(false);
		session.update(state);
		session.disconnect();
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	private Userstate createUserstate(int userId){
		Userstate state = new Userstate();
		state.setUserId(userId);
		return state;
	}

}
