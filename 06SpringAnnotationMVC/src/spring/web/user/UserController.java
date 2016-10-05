package spring.web.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.domain.User;
@Controller
public class UserController {

	public UserController() {
		System.out.println(":::UserController default Constructor call...");
	}

	@RequestMapping("/logonViewModelAndView.do")
	public ModelAndView logonViewModelAndView(){
		System.out.println("::::::LogonViewModelAndView() start.....");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/logonView.jsp");
		
		return modelAndView;
	}
	
	@RequestMapping("/logon01.do")
	public ModelAndView logon01(HttpServletRequest req){
		System.out.println("::::logon01() start.....");
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		req.setAttribute("userId", userId);
		HttpSession session = req.getSession(true);
		
		session.setAttribute("password", password);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","Controller 구현연습");
		modelAndView.setViewName("/user/logonResult.jsp");

		return modelAndView;
	}
	
	@RequestMapping("/logon02.do")
	public ModelAndView logon02(HttpServletRequest req,HttpSession session){
		System.out.println("::::logon02() start.....");
		String userId = req.getParameter("userId");
		String password = req.getParameter("password");
		
		req.setAttribute("userId", userId);
		session.setAttribute("password", password);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","Controller 구현연습");
		modelAndView.setViewName("/user/logonResult.jsp");

		return modelAndView;
	} 

	@RequestMapping("/logon03.do")
	public ModelAndView logon03(@RequestParam("userId") String userId,
								@RequestParam("password") String password,
								HttpServletRequest req,HttpSession session){
		System.out.println("::::logon03() start.....");
		
		req.setAttribute("userId", userId);
		session.setAttribute("password", password);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","Controller 구현연습");
		modelAndView.setViewName("/user/logonResult.jsp");

		return modelAndView;
	}
	
	@RequestMapping("/logon04.do")
	public ModelAndView logon04(@ModelAttribute("user") User user,
								HttpServletRequest req,HttpSession session){
		System.out.println("::::logon04() start.....");
		
		req.setAttribute("userId", user.getUserId());
		session.setAttribute("password", user.getPassword());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","Controller 구현연습");
		modelAndView.setViewName("/user/logonResult.jsp");

		return modelAndView;
	}
	
	@RequestMapping("/logon05.do")
	public ModelAndView logon05(@ModelAttribute("user") User user){
		System.out.println("::::logon05() start.....");
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("message","Controller 구현연습");
		modelAndView.setViewName("/user/logonResult.jsp");

		return modelAndView;
	}
	
	@RequestMapping("/logonViewString.do")
	public String logonViewString(){
		System.out.println("::::logonViewString() start.....");
		
		return "/user/logonView.jsp";
	}
	
	@RequestMapping("/logon06.do")
	public String logon06(@ModelAttribute("user") User user,
							HttpServletRequest req,HttpSession session,
							Map<String,String> map){
		req.setAttribute("userId", user.getUserId());
		session.setAttribute("password", user.getPassword());
		
		map.put("message", "Controller 구현연습");
		
		return "/user/logonResult.jsp";
	}
	
	@RequestMapping("/logon07.do")
	public String logon06(@RequestParam("userId") String userId,
							@RequestParam("password") String password,
							Model model){
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);
		
		model.addAttribute("user",user);
		model.addAttribute("userId",userId);
		model.addAttribute("password",password);
		model.addAttribute("message","Controller 구현연습");
		return "/user/logonResult.jsp";
	}
}
