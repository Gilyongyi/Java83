package com.model2.mvc.view.product;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.UserService;
import com.model2.mvc.service.user.impl.UserServiceImpl;

public class ListProductAction extends Action{
	
	public String execute (HttpServletRequest req, HttpServletResponse res) throws Exception{
		
Search search=new Search();
		
		int currentPage=1;

		if(req.getParameter("currentPage") != null){
			currentPage=Integer.parseInt(req.getParameter("currentPage"));
		}
		
		search.setCurrentPage(currentPage);
		search.setSearchCondition(req.getParameter("searchCondition"));
		search.setSearchKeyword(req.getParameter("searchKeyword"));
		
		// web.xml  meta-data 로 부터 상수 추출 
		int pageSize = Integer.parseInt( getServletContext().getInitParameter("pageSize"));
		int pageUnit  =  Integer.parseInt(getServletContext().getInitParameter("pageUnit"));
		search.setPageSize(pageSize);
		
		// Business logic 수행
		UserService userService=new UserServiceImpl();
		Map<String , Object> map=userService.getUserList(search);
		
		Page resultPage	= 
					new Page( currentPage, ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		System.out.println("ListUserAction ::"+resultPage);
		
		req.setAttribute("list", map.get("list"));
		req.setAttribute("resultPage", resultPage);
		req.setAttribute("search", search);
		
		return "forward:/user/listUser.jsp";
	}
}