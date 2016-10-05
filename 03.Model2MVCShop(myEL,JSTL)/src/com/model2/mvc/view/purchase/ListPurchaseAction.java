package com.model2.mvc.view.purchase;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.user.vo.UserVO;

public class ListPurchaseAction extends Action{

public String execute (HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		HttpSession session = req.getSession();
		SearchVO searchVO = new SearchVO();
		
		int page=1;
		if(req.getParameter("page") != null)
		page=Integer.parseInt(req.getParameter("page"));
		
		searchVO.setPage(page);
		searchVO.setSearchCondition(req.getParameter("searchCondition"));
		searchVO.setSearchKeyword(req.getParameter("searchKeyword"));
		
		String pageUnit=getServletContext().getInitParameter("pageSize");
		searchVO.setPageUnit(Integer.parseInt(pageUnit));
		PurchaseService service=new PurchaseServiceImpl();
		Map<String,Object> map=service.getPurchaseList(searchVO, ((UserVO)session.getAttribute("user")).getUserId());

		req.setAttribute("map", map);
		req.setAttribute("searchVO", searchVO);
		
		return "forward:/purchase/listPurchase.jsp";
	}
}
