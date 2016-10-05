package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.domain.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.domain.PurchaseVO;
import com.model2.mvc.domain.UserVO;


public class AddPurchaseAction extends Action{
	
	public String execute (HttpServletRequest req,HttpServletResponse res) throws Exception{
		PurchaseVO purchaseVO = new PurchaseVO();
		HttpSession session=req.getSession();
		UserVO userVO = (UserVO) session.getAttribute("user");
		ProductVO productVO = (ProductVO) session.getAttribute("prod");
		System.out.println(productVO);
		System.out.println(userVO);
		purchaseVO.setBuyer(userVO);
		purchaseVO.setPurchaseProd(productVO);
		purchaseVO.setPaymentOption(req.getParameter("paymentOption"));
		purchaseVO.setReceiverName(req.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(req.getParameter("receiverPhone"));
		purchaseVO.setDivyAddr(req.getParameter("receiverAddr"));
		purchaseVO.setDivyRequest(req.getParameter("receiverRequest"));
		purchaseVO.setDivyDate(req.getParameter("receiverDate"));
		System.out.println("purVO"+purchaseVO);
		PurchaseService service = new PurchaseServiceImpl();
		service.addPurchase(purchaseVO);
		
		session.setAttribute("pur", purchaseVO);
		
		
		
		
		return "forward:/purchase/addPurchaseResult.jsp";
		
	}
}
