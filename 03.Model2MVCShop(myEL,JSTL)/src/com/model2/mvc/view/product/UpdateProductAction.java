package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class UpdateProductAction extends Action{
	
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
			System.out.println(req.getParameter("prodNo"));
		int prodNo=Integer.parseInt(req.getParameter("prodNo"));
		
		ProductVO productVO = new ProductVO();

		productVO.setProdNo(prodNo);
		System.out.println(req.getParameter("prodName"));
		productVO.setProdName(req.getParameter("prodName"));
		productVO.setFileName(req.getParameter("fileName"));
		productVO.setProdDetail(req.getParameter("prodDetail"));
		productVO.setManuDate(req.getParameter("manuDate"));
		System.out.println(req.getParameter("price"));
		productVO.setPrice(Integer.parseInt(req.getParameter("price")));
		
		ProductService service= new ProductServiceImpl();
		service.updateProduct(productVO);
		
		HttpSession session=req.getSession();
		String sessionId=((ProductVO)session.getAttribute("prod")).getProdName();
		
		if(sessionId.equals(prodNo)){
			session.setAttribute("prod", productVO);
		}
		
		return "redirect:/getProduct.do?prodNo="+prodNo+"&menu=search";
		
	}
}
