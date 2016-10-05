package mini.service.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mini.common.Search;
import mini.service.domain.User;
import mini.service.user.UserDao;
import mini.service.user.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml" })
public class miniUserTest {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;
	
	@Test
	public void testAddUser() throws Exception{
		User user = new User("user22","주몽","9999","admin",new String(),new String(),new String(),new String());
		Assert.assertEquals(1,userService.addUser(user));
		System.out.println("*****testAddUser 완료*****");
	}
	
	@Test
	public void testGetUser() throws Exception{
		Assert.assertNotNull(userService.getUser("user22"));
		System.out.println("*****testGetUser 완료*****");
	}
	
	@Test
	public void testUpdateUser() throws Exception{
		User user = new User("user22","온달","9999","admin",new String(),new String(),new String(),new String());
		Assert.assertEquals(1, userService.updateUser(user));
		System.out.println("*****testUpdateUser 완료*****");
	}
		
	@Test
	public void testGetUserList() throws Exception{
		Search search = new Search();
		search.setSearchCondition("1");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("user22");
		search.setUserId(arrayList);
		Assert.assertNotNull(userService.getUserList(search));
		System.out.println("*****testGetUserList 완료*****");
	}
	
	/*@Test
	public void testAddUser2() throws Exception{
		User user = new User("user23","용이","1234","user",new String(),new String(),new String(),new String());
		Assert.assertEquals(1,userService.addUser(user));
		Assert.assertEquals(1,userService.addUser(user));
		System.out.println("*****testAddUser 완료*****");
	}
	*/
	
}
