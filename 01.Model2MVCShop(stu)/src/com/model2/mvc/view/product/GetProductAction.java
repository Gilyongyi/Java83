package com.model2.mvc.view.product;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.domain.ProductVO;

public class GetProductAction extends Action{
	
	public String execute (HttpServletRequest req,HttpServletResponse res)throws Exception{
		
		int prodNo=Integer.parseInt(req.getParameter("prodNo"));
		
		ProductService service = new ProductServiceImpl();
		ProductVO vo = service.getProduct(prodNo);
		System.out.println("여기는 getProductAction::"+vo);
		req.setAttribute("vo", vo);
		HttpSession session=req.getSession();
		session.setAttribute("prod", vo);
		
		if(req.getParameter("menu").equals("manage")){
			return "forward:/product/updateProduct.jsp";
		}else{
			String A=req.getParameter("prodNo");
			Cookie[] cookies = req.getCookies();
			String B = null;
			if(cookies!=null){
				for(int i=0;i<cookies.length;i++){
					String name = cookies[i].getName();
					String value = cookies[i].getValue();
					
					if(name.equals("history")){
						B =value;
					}
				}
			}
			B+=(","+A);
			Cookie cookie = new Cookie("history",B);
			cookie.setMaxAge(60*30);
			res.addCookie(cookie);
				
			System.out.println("쿠키 저장 완료");
			return "forward:/product/getProduct.jsp";
		}
	}
}
