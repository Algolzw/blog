package gblog.user;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.inter.UserBase;
import domain.User;

public class UserBaseTest extends TestCase {

	private UserBase dao;

	@SuppressWarnings("resource")
	protected void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-test.xml", "spring-service.xml" });
		dao = (UserBase) context.getBean("userBaseImpl");
		super.setUp();
	}

	public void testValidateUser() {
		User user = dao.validateUser("algo_lzw", "luoziwei1993");
		assert (user != null);
	}

	public void testExist() {
		assert (dao.exist("algo_lzw"));
		assert (!dao.exist("algo"));
	}

	public void testCreateString() {
//		User user = dao.create("test");
//		assertEquals(user.getUserId(), new Integer(2));
	}

	public void testCreateStringBoolean() {
		
	}

	public void testFindById() {
		User user = dao.findById(1);
		assertEquals(user.getUsername(), "algo_lzw");
	}

	public void testFindByName() {
		User user = dao.findByName("test");
		assertNotNull (user);
	}

	public void testChangeUserName() {
		dao.changeUserName("test", "test2");
		assertNotNull(dao.findByName("test2"));
	}

	public void testDelete() {
		dao.delete(dao.findByName("test2").getUserId(),true);
		assertNull(dao.findById(2));
	}

}
