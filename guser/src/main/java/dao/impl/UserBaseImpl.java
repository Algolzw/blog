package dao.impl;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import dao.inter.UserBase;
import domain.User;
import domain.Userstate;

@Component
public class UserBaseImpl implements UserBase {

	private SessionFactory sessionFactory;

	@Inject
	public UserBaseImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User validateUser(String username, String password) {
		Session session = this.sessionFactory.openSession();
		User user = null;
		try {
			String sql = "from User as u where u.username=:name and u.userstate.password=:psd and u.deleted=false";
			user = (User) session.createQuery(sql)
					.setParameter("name", username)
					.setParameter("psd", password).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.disconnect();
		}

		return user;
	}

	@Override
	public boolean exist(String username) {
		Session session = this.sessionFactory.openSession();
		int count = 0;
		try {
			String sql = "select count(u) from User as u where u.username=:name and u.deleted=0";
			count = (Integer) session.createQuery(sql)
					.setParameter("name", username).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.disconnect();
		}
		return count > 0;
	}

	@Override
	public User create(String username) {
		Session session = this.sessionFactory.openSession();
		User user = new User(username, false, false);
		session.save(user);
		return user;
	}

	@Override
	public User create(String username, boolean anonymous) {
		Session session = this.sessionFactory.openSession();
		User user = new User(username, anonymous, false);
		session.save(user);
		return user;
	}

	@Override
	public User findById(int userId) {
		Session session = this.sessionFactory.openSession();
		return (User) session.get(User.class, userId);
	}

	@Override
	public User findByName(String username) {
		Session session = this.sessionFactory.openSession();
		return (User) session
				.createQuery(
						"from User as u where u.username=:name and u.deleted=false")
				.setParameter("name", username).uniqueResult();
	}

}
