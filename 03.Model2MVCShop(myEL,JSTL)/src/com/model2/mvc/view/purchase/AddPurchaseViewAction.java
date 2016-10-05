package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class AddPurchaseViewAction extends Action {

	@Override
	public String execute(	HttpServletRequest req,	HttpServletResponse res) throws Exception {
		
		int prodNo =Integer.parseInt(req.getParameter("prodNo"));
		ProductService service = new ProductServiceImpl();
		ProductVO vo = service.getProduct(prodNo);
				
		req.setAttribute("ProductVO", vo);
		
		HttpSession session=req.getSession();
		session.setAttribute("ProductVO", prodNo);
		
		return "redirect:/purchase/addPurchaseView.jsp";
	}
}