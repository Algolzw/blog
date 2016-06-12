package dao.impl;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
			session.close();
		}
		return user;
	}

	@Override
	public boolean exist(String username) {
		Session session = this.sessionFactory.openSession();
		long count = 0;
		try {
			String sql = "select count(u) from User as u where u.username=:name and u.deleted=0";
			count = (long) session.createQuery(sql)
					.setParameter("name", username).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			session.close();
		}
		return count > 0;
	}

	@Override
	public User create(String username) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		User user = new User(username, false, false);
		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public User create(String username, boolean anonymous) {
		Session session = this.sessionFactory.openSession();
		User user = new User(username, anonymous, false);
		session.save(user);
		session.close();
		return user;
	}

	@Override
	public User findById(int userId) {
		Session session = this.sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

	@Override
	public User findByName(String username) {
		Session session = this.sessionFactory.openSession();
		User user = (User) session
				.createQuery(
						"from User as u where u.username=:name and u.deleted=false")
				.setParameter("name", username).uniqueResult();
		session.close();
		return user;
	}

	@Override
	public void delete(int userId) {
		Session session = this.sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		user.setDeleted(true);
		session.saveOrUpdate(user);
		session.close();
	}

	@Override
	public void delete(int userId, boolean realDelete) {
		if (!realDelete)
			delete(userId);
		else {
			Session session = this.sessionFactory.openSession();
			String hql = "delete from User u where u.userId=:id";
			Transaction trans = session.beginTransaction();
			Query query = session.createQuery(hql).setParameter("id", userId);
			query.executeUpdate();
			trans.commit();
			session.close();
		}
	}

	@Override
	public void changeUserName(String oldName, String newName) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		try {
			Query query = session
					.createQuery(
							"update User as u set u.username=:newname where u.username=:oldname and u.deleted=false")
					.setParameter("newname", newName)
					.setParameter("oldname", oldName);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

}
