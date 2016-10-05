package spring.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import spring.domain.User;

public class LogonCheckInterceptor extends HandlerInterceptorAdapter{
	
	public LogonCheckInterceptor(){
		System.out.println("[LogonCheckInterceptor() default Constructor call....");
	}
	
	public boolean preHandle(HttpServletRequest req,HttpServletResponse res,Object handler)throws Exception{
		System.out.println("\n[LogonCheckInterceptor start.......]");
		
		HttpSession session =req.getSession(true);
		User sessionUser=null;
		
		if((sessionUser=(User)session.getAttribute("sessionUser"))==null){
			sessionUser=new User();
		}
		
		if(sessionUser.isActive()){
			String uri=req.getRequestURI();
			if(uri.indexOf("logonAction")!=-1||uri.indexOf("logon")!=-1){
				req.getRequestDispatcher("/user002/home.jsp").forward(req, res);
				System.out.println("[로그인 상태...로그인 후 불필요한 요구...]");
				System.out.println("[LogonCheckInterceptor end....]\n");
				return false;
			}
			
			System.out.println("[로그인 상태...]");
			System.out.println("[LogonCheckInterceptor end....]\n");
			return true;
		}else{
			String uri=req.getRequestURI();
			if(uri.indexOf("logonAction")!=-1||uri.indexOf("logon")!=-1){
				System.out.println("[로그인 시도상태....]");
				System.out.println("[LogonCheckInterceptor end....]\n");
				return true;
			}
			
			req.getRequestDispatcher("/user002/logon.jsp").forward(req, res);
			System.out.println("[로그인 이전...]");
			System.out.println("[LogonCheckInterceptor end....]\n");
			return false;
		}
	}
}
