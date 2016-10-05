package spring.model2.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {

	public ViewResolver() {
	}
	
	public void forward(HttpServletRequest req,HttpServletResponse res,ModelAndView modelAndView) 
									throws ServletException,IOException{
		System.out.println("[ViewResolver.forward() start.......");
		
		if(modelAndView.getModelName()!=null){
			req.setAttribute(modelAndView.getModelName(),
							modelAndView.getModelObject());
		}
		
		req.getRequestDispatcher(modelAndView.getViewName()).forward(req, res);
		
		System.out.println("[ViewResolver.forward() end.......");
	}
	
}
