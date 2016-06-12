package dao.impl;

import java.util.Date;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import dao.inter.UserState;
import domain.Userstate;

@Component
public class UserStateImpl implements UserState {

	private SessionFactory sessionFactory;

	@Inject
	public UserStateImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void initState(int userId) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		Userstate state = new Userstate();
		state.setUserId(userId);
		try {
			session.save(state);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void initState(int userId, String password) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		try {
			Userstate state = new Userstate();
			state.setUserId(userId);
			state.setPassword(password);
			session.save(state);
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void approve(int userId) {
		Session session = this.sessionFactory.openSession();
		String hql = "update Userstate us set us.approved = true where us.userId=:id";
		Transaction trans = session.beginTransaction();
		try {
			Query query = session.createQuery(hql).setParameter("id", userId);
			query.executeUpdate();
			trans.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

	@Override
	public void loginUpdate(int userId) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		try{
			String hql = "update Userstate us set us.online = true and us.lastLoginTime=:time where us.userId=:id";
			Query query = session.createQuery(hql).setParameter("time", new Date()).setParameter("id", userId);
			query.executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e){
			throw e;
		}finally{
			session.close();
		}
	}

	@Override
	public void logoutUpdate(int userId) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		try{
			String hql = "update Userstate us set us.online = false where us.userId=:id";
			Query query = session.createQuery(hql).setParameter("id", userId);
			query.executeUpdate();
			session.getTransaction().commit();
		}catch(Exception e){
			throw e;
		}finally{
			session.close();
		}
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	private Userstate createUserstate(int userId) {
		Userstate state = new Userstate();
		state.setUserId(userId);
		return state;
	}

}
