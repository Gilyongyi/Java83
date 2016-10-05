package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.domain.PurchaseVO;

public class UpdateTranCodeByProdAction extends UpdateTranCodeAction {
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		PurchaseService service=new PurchaseServiceImpl();
		PurchaseVO purchaseVO=service.getPurchase2(Integer.parseInt(req.getParameter("prodNo")));
		purchaseVO.setTranCode(req.getParameter("tranCode").trim());
		
		service.updateTranCode(purchaseVO);
		req.setAttribute("PurchaseVO", purchaseVO);
		
		return "forward:/listProduct.do?menu=manage";
	}
}
