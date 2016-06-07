package dao.impl;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import utils.HibernateUtil;
import dao.inter.UserDAO;
import domain.User;

@Repository("userDAOImpl")
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
	
	public UserDAOImpl(){
	}
	
	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User getName(String username){
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("select * from User where username = :username").addEntity(User.class);
		query.setString("username", username);
		return (User)query.uniqueResult();	
	}
	
	@Override
	public String getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String user = (String)session.createSQLQuery("select username from User as u where u.userId = :id")
							.setParameter("id", id)
							.uniqueResult();
		return user;
	}

}
