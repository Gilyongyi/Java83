package com.model2.mvc.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.user.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;
	
	public UserController() {
		System.out.println("UserController default Constructor call....");
	}
	
	@RequestMapping("login")
	public ModelAndView login(@ModelAttribute("user") User user,HttpSession session) throws Exception{
		System.out.println("\n[login() start]");
		
		User returnUser = userService.getUser(user.getUserId());
		if(!returnUser.getPassword().equals(user.getPassword())){
			System.out.println("로그인 실패!!!!");
		}else{
		session.setAttribute("user", returnUser);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index.jsp");		
		
		System.out.println("\n[login() end]");
		
		return modelAndView;
	}
	
	@RequestMapping("getUser")
	public ModelAndView getUser(@ModelAttribute("user") User user) throws Exception{
		System.out.println("\n[getUser() start]");
		
		User returnUser = userService.getUser(user.getUserId());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/getUser.jsp");
		modelAndView.addObject("user",returnUser);

		System.out.println("\n[getUser() end]");
		
		return modelAndView;
	}
	
	@RequestMapping("addUser")
	public ModelAndView addUser(@ModelAttribute("user")User user) throws Exception{
		System.out.println("\n[addUser() start]");
		
		userService.addUser(user);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index.jsp");
		
		System.out.println("\n[addUser() end]");
		
		return modelAndView;
	}
		
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session){
		System.out.println("\n[logout() start]");
		
		session.removeAttribute("user");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/index.jsp");
		System.out.println("\n[logout() end]");
		return modelAndView;
	}
	
	@RequestMapping(value="updateUser",method=RequestMethod.GET)
	public ModelAndView updateUser(@ModelAttribute("user")User user){
		System.out.println("\n[updateUser() method=RequestMethod.GET start]");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/updateUser.jsp");
		
		System.out.println("\n[updateUser() method=RequestMethod.GET end]");
		
		return modelAndView;
	}
	
	@RequestMapping(value="updateUser",method=RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("user") User user,HttpSession session) throws Exception{
		System.out.println("\n[updateUser() method=RequestMethod.POST start]");
				
		userService.updateUser(user);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/getUser.jsp");
		
		System.out.println("\n[updateUser() method=RequestMethod.POST end]");
		
		return modelAndView;
	}
	
	@RequestMapping("listUser")
	public ModelAndView listUser(Map<String,Object> map,
								HttpServletRequest req) throws Exception{
		System.out.println("\n[listUser() start]");
		Search search = new Search();		
		int currentPage=1;

		if(req.getParameter("currentPage") != null){
			currentPage=Integer.parseInt(req.getParameter("currentPage"));
		}
		
		search.setCurrentPage(currentPage);
		search.setSearchCondition(req.getParameter("searchCondition"));
		search.setSearchKeyword(req.getParameter("searchKeyword"));
		
		int pageSize = Integer.parseInt( req.getServletContext().getInitParameter("pageSize"));
		int pageUnit  =  Integer.parseInt(req.getServletContext().getInitParameter("pageUnit"));
		search.setPageSize(pageSize);
		
		map=userService.getUserList(search);		
		Page resultPage	= 
		new Page( currentPage, ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
	
		req.setAttribute("list", map.get("list"));
		req.setAttribute("resultPage", resultPage);
		req.setAttribute("search", search);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/user/listUser.jsp");
		
		System.out.println("\n[listUser() end]");
		return modelAndView;
	}
	
}
