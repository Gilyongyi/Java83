package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.domain.PurchaseVO;

public class GetPurchaseAction extends Action{
	
	public String execute (HttpServletRequest req,HttpServletResponse res)throws Exception{
		
		int tranNo=Integer.parseInt(req.getParameter("tranNo"));
		
		PurchaseService service = new PurchaseServiceImpl();
		PurchaseVO vo = service.getPurchase(tranNo);
		
		req.setAttribute("vo", vo);
		HttpSession session=req.getSession();
		session.setAttribute("pur", vo);
	
		return "forward:/purchase/getPurchase.jsp";
	}
}

