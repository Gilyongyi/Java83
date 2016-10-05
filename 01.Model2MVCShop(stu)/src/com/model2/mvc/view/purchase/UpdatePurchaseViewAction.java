package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.domain.PurchaseVO;


public class UpdatePurchaseViewAction extends Action{

	@Override
	public String execute(	HttpServletRequest req,
												HttpServletResponse res) throws Exception {
		int tranNo=Integer.parseInt(req.getParameter("tranNo"));
		
		PurchaseService service=new PurchaseServiceImpl();
		PurchaseVO purchaseVO=service.getPurchase(tranNo);
		
		req.setAttribute("PurchaseVO", purchaseVO);
		
		return "forward:/purchase/updatePurchase.jsp";
	}
}
