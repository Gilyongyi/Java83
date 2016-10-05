package com.model2.mvc.view.purchase;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.common.PageVO;
import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.domain.ProductVO;
import com.model2.mvc.domain.PurchaseVO;
import com.model2.mvc.domain.UserVO;

public class ListPurchaseAction extends Action{

public String execute (HttpServletRequest req, HttpServletResponse res) throws Exception{
	String buyerId = new String();	
	SearchVO searchVO = new SearchVO();
	PageVO pageVO = new PageVO();
	int currentPage=1;

	if(req.getParameter("currentPage") != null){
		currentPage=Integer.parseInt(req.getParameter("currentPage"));
	}
	
	searchVO.setCurrentPage(currentPage);
	searchVO.setSearchCondition(req.getParameter("searchCondition"));
	searchVO.setSearchKeyword(req.getParameter("searchKeyword"));
	
	if(req.getParameter("order")!=null){
	searchVO.setOrder(req.getParameter("order"));
	}
	int pageSize = Integer.parseInt( getServletContext().getInitParameter("pageSize"));
	int pageUnit  =  Integer.parseInt(getServletContext().getInitParameter("pageUnit"));
	searchVO.setPageSize(pageSize);
	HttpSession session = req.getSession();
	buyerId=((UserVO)session.getAttribute("user")).getUserId();
	PurchaseService service=new PurchaseServiceImpl();
	Map<String,Object> map=service.getPurchaseList(searchVO,buyerId);
	
	int totalCount=0;
	ArrayList<PurchaseVO> list=null;
	if(map != null){
		totalCount=((Integer)map.get("count")).intValue();
		list=(ArrayList<PurchaseVO>)map.get("list");
	}
	PageVO resultPage	= 
			new PageVO( currentPage, totalCount, pageUnit, pageSize);
	System.out.println("ListPurchaseAction ::"+resultPage);
	
	pageVO.setCurrentPage(currentPage);
	pageVO.setPageSize(pageSize);
	pageVO.setPageUnit(pageUnit);
	pageVO.setTotalCount(totalCount);
	req.setAttribute("pageVO", resultPage);
	req.setAttribute("list", list);
	req.setAttribute("map", map);
	req.setAttribute("searchVO", searchVO);
	
		
		return "forward:/purchase/listPurchase.jsp";
	}
}
