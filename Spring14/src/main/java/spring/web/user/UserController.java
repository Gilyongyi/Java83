package spring.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.User;

@Controller
@RequestMapping("/user/*")
public class UserController {

	public UserController(){
		System.out.println("::UserController default Constructor class");
	}
	
	@RequestMapping("testView")
	public ModelAndView testView(){
		return new ModelAndView("/test/testView.jsp");
	}
	
	@RequestMapping(value="getUser/{userId}",method=RequestMethod.GET)
	public ModelAndView getUser(@PathVariable String userId){
		System.out.println();
		System.out.println(userId);
		User user = new User();
		user.setUserId(userId);
		
		return new ModelAndView("/test/testView.jsp","user",user);
	}
	
	@RequestMapping(value="getUser/{userId}",method=RequestMethod.POST)
	public ModelAndView getUser(@PathVariable String userId,
								@ModelAttribute("user")User user){
		System.out.println();
		System.out.println(userId);
		System.out.println(user);
		user.setUserId(userId);
		
		return new ModelAndView("/test/testView.jsp","user",user);
	}
	
	@RequestMapping(value="json/{value}",method=RequestMethod.GET)
	public void getUser(@PathVariable String value,
						@RequestParam("name")String name,
						@RequestParam("age")int age,
						Model model)throws Exception{
		System.out.println();
		System.out.println(value);
		System.out.println(name);
		System.out.println(age);
		
		User user = new User();
		user.setUserId(value);
		user.setUserName("이순신");
		user.setAge(age);
		System.out.println(user);
		
		model.addAttribute("user",user);
		model.addAttribute("message","ok");
	}
	
	@RequestMapping(value="json/{value}",method=RequestMethod.POST)
	public void getUser(@PathVariable String value,
						Model model)throws Exception{
		System.out.println();
		System.out.println(value);
		
		User user = new User();
		user.setUserId(value);
		user.setUserName("이순신");
		System.out.println(user);
		
		model.addAttribute("user",user);
	}
	
	@RequestMapping(value="json/getUser/{value}",method=RequestMethod.POST)
	public void getUser(@PathVariable String value,
						@RequestBody User user,
						Model model) throws Exception{
		System.out.println();
		System.out.println("[From Client Data]");
		System.out.println(value);
		System.out.println("1 : "+user);
		
		System.out.println("[To Client Data]");
		user.setUserId(value);
		user.setUserName("이순신");
		System.out.println("2 : "+user);
		
		model.addAttribute("user",user);
	}
}
