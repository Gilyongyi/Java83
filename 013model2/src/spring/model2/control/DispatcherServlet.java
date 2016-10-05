package spring.model2.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res)
											throws ServletException,IOException{
		System.out.println("\n[DispatcherServlet.service() start....]");
		
		String actionPage = this.getURI(req.getRequestURI());
		System.out.println("::URI? =>: "+req.getRequestURI());
		System.out.println("::client의 요구사항은 ? =>: "+actionPage);
		
		req.setCharacterEncoding("EUC_KR");
		
		Controller controller = null;
		
		ControllerMapping cf = ControllerMapping.getInstance();
		controller=cf.getController(actionPage);
		
		controller.execute(req, res);
		System.out.println("[DispatcherServlet.service() end....]");
	}
	
	private String getURI(String requestURI){
		int start = requestURI.lastIndexOf('/')+1;
		int end = requestURI.lastIndexOf(".do");
		String actionPage = requestURI.substring(start, end);
		return actionPage;
	}
}
