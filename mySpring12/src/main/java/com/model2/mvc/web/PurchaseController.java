package com.model2.mvc.web;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;

@Controller
public class PurchaseController {
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	public PurchaseController() {
		System.out.println("PurchaseController default Constructor call....");
	}
	
	@RequestMapping(value="/addPurchaseView.do",method=RequestMethod.GET)
	public String addPurchase(@ModelAttribute("purchase")Purchase purchase,
							HttpServletRequest req,HttpSession session) throws NumberFormatException, Exception{
		System.out.println("[addPurchase() method=RequestMethod.GET start");	
		
		session.getAttribute("user");
		req.setAttribute("product", productService.getProduct(Integer.parseInt(req.getParameter("prodNo"))));
		req.setAttribute("purchase", purchase);
		System.out.println("[addPurchase() method=RequestMethod.GET end");
		return "/purchase/addPurchaseView.jsp"; 
	}
	
	@RequestMapping(value="/addPurchase.do",method=RequestMethod.POST)
	public String addPurchase(@ModelAttribute("purchase")Purchase purchase,
							@ModelAttribute("product")Product product,
							HttpServletRequest req,HttpSession session) throws Exception{
		System.out.println("[addPurchase() method=RequestMethod.POST start");
		purchase.setBuyer((User)session.getAttribute("user"));
		purchase.setPurchaseProd(productService.getProduct(Integer.parseInt(req.getParameter("prodNo"))));
		purchaseService.addPurchase(purchase);
		System.out.println("[addPurchase() method=RequestMethod.POST end");	
		
		return "/purchase/addPurchaseResult.jsp";
	}
	
	@RequestMapping("/getPurchase.do")
	public String getPurchase(@ModelAttribute("purchase")Purchase purchase,
								HttpServletRequest req) throws Exception{
		System.out.println("[getPurchase() start]");
		
		req.setAttribute("vo", purchaseService.getPurchase(purchase.getTranNo()));
		System.out.println("[getPurchase() end]");
		return "/purchase/getPurchase.jsp";
	}
	
	
	@RequestMapping(value="/updatePurchaseView.do",method=RequestMethod.GET)
	public String updatePurchase(@ModelAttribute("purchase")Purchase purchase){
		System.out.println("[updatePurchase() method=RequestMethod.GET start]");
		System.out.println("[updatePurchase() method=RequestMethod.GET end]");
		return "/purchase/updatePurchase.jsp";
	}
	
	@RequestMapping("/updatePurchase.do")
	public String updatePurchase(@ModelAttribute("purchase")Purchase purchase,
									HttpServletRequest req) throws Exception{
		System.out.println("[updatePurchase() method=RequestMethod.POST start");
		req.setAttribute("purchase", purchaseService.updatePurchase(purchase));
		System.out.println("[updatePurchase() method=RequestMethod.POST end]");
		return "/purchase/getPurchase.jsp";
	}
	
	@RequestMapping("/listPurchase.do")
	public String listPurchase(HttpServletRequest req,HttpSession session,Map<String,Object> map) throws Exception{
		System.out.println("[listPurchase() start");
		String buyerId = new String();	
		Search search = new Search();
		Page page = new Page();
		int currentPage=1;

		if(req.getParameter("currentPage") != null){
			currentPage=Integer.parseInt(req.getParameter("currentPage"));
		}
		
		search.setCurrentPage(currentPage);
		search.setSearchCondition(req.getParameter("searchCondition"));
		search.setSearchKeyword(req.getParameter("searchKeyword"));
		
		if(req.getParameter("order")!=null){
		search.setOrder(req.getParameter("order"));
		}
		int pageSize = Integer.parseInt( req.getServletContext().getInitParameter("pageSize"));
		int pageUnit  =  Integer.parseInt(req.getServletContext().getInitParameter("pageUnit"));
		search.setPageSize(pageSize);
		session = req.getSession();
		buyerId=((User)session.getAttribute("user")).getUserId();
		System.out.println("asdasd : "+buyerId);
		map=purchaseService.getPurchaseList(search,buyerId);
		
		int totalCount=0;
		ArrayList<Purchase> list=null;
		if(map != null){
			list=(ArrayList<Purchase>)map.get("list");
		}
		Page resultPage	= 
				new Page( currentPage, totalCount, pageUnit, pageSize);
		System.out.println("ListPurchaseAction ::"+resultPage);
		
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		page.setPageUnit(pageUnit);
		page.setTotalCount(totalCount);
		req.setAttribute("pageVO", resultPage);
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		req.setAttribute("searchVO", search);
		System.out.println("[listPurchase() end");
		
		return "/purchase/listPurchase.jsp";
	}
	
	@RequestMapping("/updateTranCode.do")
	public String updateTranCode(@ModelAttribute("purchase")Purchase purchase
								,HttpServletRequest req) throws Exception{
		System.out.println("updateTranCode() start");
		
		System.out.println("updateTranCode() end");
		return "/purchase/listPurchase.jsp";
	}
	
	@RequestMapping("/updateTranCodeByProd.do")
	public String getPurchase2(@ModelAttribute("purchase")Purchase purchase,
								@ModelAttribute("product")Product product,
								HttpServletRequest req) throws Exception{
		System.out.println("getPurchase2() start");
		purchase.setPurchaseProd(productService.getProduct(product.getProdNo()));
		req.setAttribute("purchase", purchaseService.getPurchase2(product.getProdNo()));
		req.setAttribute("purchase", purchaseService.updateTranCode(purchase));
		System.out.println("getPurchase2() end");
		return "/product/listProduct.jsp";
	}
	
	
	
}
