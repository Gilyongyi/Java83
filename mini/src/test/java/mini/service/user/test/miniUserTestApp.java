package mini.service.user.test;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mini.common.Search;
import mini.service.domain.User;
import mini.service.user.UserService;
import mini.service.user.impl.UserServiceImpl;

public class miniUserTestApp {
	
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[]{"/config/commonservice.xml"});
		System.out.println("\n");
		
		UserService userService = (UserServiceImpl) context.getBean("userServiceImpl");
		
				User user = new User("user22","аж╦Ы","9999","admin",new String(),new String(),new String(),new String());
				
				System.out.println(":: 1. addUser(INSERT)  ? ");
				System.out.println(":: "+ userService.addUser(user));
				System.out.println("\n");
				
				System.out.println(":: 2. getUser(SELECT)  ? ");
				System.out.println(":: "+ userService.getUser(user.getUserId()));
				System.out.println("\n");
				
				System.out.println(":: 3. update(UPDATE)  ? ");
				System.out.println(":: "+userService.updateUser(user));
				System.out.println("\n");
				
				Search search = new Search();
				search.setSearchCondition("1");
				ArrayList<String> arrayList = new ArrayList<String>();
				arrayList.add("user22");
				search.setUserId(arrayList);
				
				System.out.println(":: 4. getUserList(List)  ? ");
				System.out.println(":: "+userService.getUserList(search));
				System.out.println("\n");
				
			}//end of main
		}//end of class