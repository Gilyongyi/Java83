package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.domain.PurchaseVO;

public class UpdateTranCodeAction extends Action{
		
		public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
			
			PurchaseService service=new PurchaseServiceImpl();
			PurchaseVO purchaseVO=service.getPurchase(Integer.parseInt(req.getParameter("tranNo")));
			purchaseVO.setTranCode(req.getParameter("tranCode").trim());
			
			service.updateTranCode(purchaseVO);
			req.setAttribute("PurchaseVO", purchaseVO);
			
			return "forward:/listPurchase.do";
		}
	}

