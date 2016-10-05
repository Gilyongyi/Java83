package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class GetPurchaseAction extends Action{
	
	public String execute (HttpServletRequest req,HttpServletResponse res)throws Exception{
		
		int tranNo=Integer.parseInt(req.getParameter("tranNo"));
		/*System.out.println("*************"+req.getParameter("tranNo"));*/
		PurchaseService service = new PurchaseServiceImpl();
		PurchaseVO vo = service.getPurchase(tranNo);
		System.out.println("¿©±â´Â GetPurchaseAction:::"+vo);
		/*HttpSession session=req.getSession();
		session.setAttribute("pur", vo);*/
		req.setAttribute("pur", vo);
		/*if(req.getParameter("menu").equals("manage")){
			return "forward:/product/updateProduct.jsp";
		}else{*/
			return "forward:/purchase/getPurchase.jsp";
		//}
	}
}

