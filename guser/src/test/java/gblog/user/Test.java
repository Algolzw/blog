package gblog.user;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.impl.UserDAOImpl;
import dao.inter.UserDAO;
import domain.User;

public class Test {
	
	
	public static void main(String[] args){
		System.out.println(getNameWithSpringBeanName("algo_lzw"));
	}
	
	static String getNameWithCfgXmlFile(int id){
		UserDAO home = new UserDAOImpl();
		return home.getById(id);
	}
	
	@SuppressWarnings("resource")
	static User getNameWithSpringBeanName(String name){
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-service.xml","spring-hibernate.xml"});
		UserDAO dao = (UserDAO)context.getBean("userDAOImpl");
		return dao.getName(name);
	}
}
