package spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.User;
import spring.service.user.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	public UserController() {
		System.out.println("UserController default Constructor call....");
	}
	@RequestMapping
	public String logon(HttpSession session,Model model){
		System.out.println("\n[logon()start....]");
		
		String message = "[logon()] 아이디, 패스워드 3자이상 입력하세요.";
		model.addAttribute("message",message);
		
		System.out.println("[logon() end.......]\n");
		
		return "/user/logon.jsp";
	}
	
	@RequestMapping
	public String home(Model model){
		System.out.println("\n[home() start....]");
		
		String message = "[home()] WELCOME";
		
		model.addAttribute("message", message);

		System.out.println("[home() end.......]\n");
		
		return "/user/home.jsp";
	}
	
/*	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView logonAction(){
		System.out.println("\n[logonAction() method=RequestMethod.GET start....]");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/logon.do");
		System.out.println("[LogonAction() method=RequestMethod.GET end.....]\n");
		
		return modelAndView;
	}*/
	
	@RequestMapping(method=RequestMethod.POST)
	public String logonAction(@ModelAttribute("user") User user,
									HttpSession session,Model model) throws Exception{
		System.out.println("\n[logonAction() method=RequestMethod.POST start....]");
		
		String viewName="/user/logon.jsp";
		
		User returnUser = userService.getUser(user.getUserId());
		if(returnUser.getPassword().equals(user.getPassword())){
			returnUser.setActive(true);
			user=returnUser;
		}
		
		if(user.isActive()){
			viewName = "/user/home.jsp";
			session.setAttribute("sessionUser", user);	
		}	
		System.out.println("[action : "+viewName+" ]");
		
		String message = null;
		if(viewName.equals("user/home.jsp")){
			message = "[LogonAction()] WELCOME";
		}else{
			message = "[LogonAction()] 아이디, 패스워드 3자이상 입력하세요.";
		}

		model.addAttribute("message",message);

		System.out.println("[LogonAction() method=RequestMethod.POST end.....]\n");
		
		return viewName;
	}
	
	
	@RequestMapping
	public String logout(HttpSession session,Model model){
		System.out.println("\n[logout() start.....]");
		
		session.removeAttribute("sessionUser");
				
		String message = "[LogonAction()] 아이디, 패스워드 3자이상 입력하세요.";

		model.addAttribute("message", message);

		System.out.println("[Logout() end.....\n");
		
		return "/user/logon.jsp";
	}
}
