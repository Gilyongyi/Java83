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
import org.springframework.web.bind.annotation.RequestParam;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseService;

@Controller
@RequestMapping("/purchase/*")
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
	
	@RequestMapping(value="addPurchaseView",method=RequestMethod.GET)
	public String addPurchase(@ModelAttribute("purchase")Purchase purchase,
							HttpServletRequest req,HttpSession session) throws NumberFormatException, Exception{
		System.out.println("[addPurchase() method=RequestMethod.GET start");	
		
		session.getAttribute("user");
		req.setAttribute("product", productService.getProduct(Integer.parseInt(req.getParameter("prodNo"))));
		req.setAttribute("purchase", purchase);
		System.out.println("[addPurchase() method=RequestMethod.GET end");
		return "/purchase/addPurchaseView.jsp"; 
	}
	
	@RequestMapping(value="addPurchase",method=RequestMethod.POST)
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
	
	@RequestMapping("getPurchase")
	public String getPurchase(@ModelAttribute("purchase")Purchase purchase,
								HttpServletRequest req) throws Exception{
		System.out.println("[getPurchase() start]");
		req.setAttribute("vo", purchaseService.getPurchase(purchase.getTranNo()));
		System.out.println("[getPurchase() end]");
		return "/purchase/getPurchase.jsp";
	}
	
	
	@RequestMapping(value="updatePurchaseView",method=RequestMethod.GET)
	public String updatePurchase(@ModelAttribute("purchase")Purchase purchase){
		System.out.println("[updatePurchase() method=RequestMethod.GET start]");
		System.out.println("[updatePurchase() method=RequestMethod.GET end]");
		return "/purchase/updatePurchase.jsp";
	}
	
	@RequestMapping("updatePurchase")
	public String updatePurchase(@ModelAttribute("purchase")Purchase purchase,
									HttpServletRequest req) throws Exception{
		System.out.println("[updatePurchase() method=RequestMethod.POST start");
		purchaseService.updatePurchase(purchase);
		req.setAttribute("vo", purchase);
		System.out.println("[updatePurchase() method=RequestMethod.POST end]");
		return "/purchase/getPurchase.jsp";
	}
	
	@RequestMapping("listPurchase")
	public String listPurchase(HttpServletRequest req,HttpSession session,
								Map<String,Object> map) throws Exception{
		System.out.println("[listPurchase() start");
		String buyerId = new String();	
		Search search = new Search();
		Page page = new Page();
		int currentPage=1;
		
		if(req.getParameter("tranCo")!=null){
			search.setTranCo(Integer.parseInt(req.getParameter("tranCo")));
			}
		/*if(req.getParameter("currentPage") != null){
			currentPage=Integer.parseInt(req.getParameter("currentPage"));
		}
		
		search.setCurrentPage(currentPage);
		search.setSearchCondition(req.getParameter("searchCondition"));
		search.setSearchKeyword(req.getParameter("searchKeyword"));*/
		
		if(req.getParameter("order")!=null){
		search.setOrder(req.getParameter("order"));
		}
		int pageSize = Integer.parseInt( req.getServletContext().getInitParameter("pageSize"));
		int pageUnit  =  Integer.parseInt(req.getServletContext().getInitParameter("pageUnit"));
		search.setPageSize(pageSize);
		
		session = req.getSession();
		buyerId=((User)session.getAttribute("user")).getUserId();
		
		map=purchaseService.getPurchaseList(search,buyerId);
		
		int totalCount=0;
		ArrayList<Purchase> list=null;
		if(map != null){
			list=(ArrayList<Purchase>)map.get("list");
		}
		Page resultPage	= 
				new Page( currentPage, totalCount, pageUnit, pageSize);
		
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		page.setPageUnit(pageUnit);
		page.setTotalCount(totalCount);
		req.setAttribute("page", resultPage);
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		req.setAttribute("search", search);
		System.out.println("[listPurchase() end");
		
		return "/purchase/listPurchase.jsp";
	}
	
	@RequestMapping("updateTranCode")
	public String updateTranCode(@ModelAttribute("purchase")Purchase purchase
								,HttpServletRequest req) throws Exception{
		System.out.println("updateTranCode() start");
		
		purchase = purchaseService.getPurchase(Integer.parseInt(req.getParameter("tranNo")));
		purchase.setTranCode(req.getParameter("tranCode"));
		purchaseService.updateTranCode(purchase);	
		
		System.out.println("updateTranCode() end");
		return "/purchase/listPurchase?menu=search";
	}
	
	@RequestMapping("getPurchase2")
	public String getPurchase2(@ModelAttribute("purchase")Purchase purchase,
								@RequestParam("prodNo")int prodNo,
								HttpServletRequest req) throws Exception{
		System.out.println("getPurchase2() start");
	
		purchase.setPurchaseProd(productService.getProduct(prodNo));
		purchase.setTranCode(req.getParameter("tranCode"));
		purchaseService.updateTranCode(purchase);
		System.out.println("getPurchase2() end");
		return "/product/listProduct?menu=manage";
	}
	
	@RequestMapping("deletePurchase")
	public String deletePurchase(@ModelAttribute("purchase")Purchase purchase) throws Exception{
		System.out.println("deletePurchase() start");
		purchaseService.deletePurchase(purchase.getTranNo());
		System.out.println("deletePurchase() end");
		return "/purchase/listPurchase?menu=search";
	}
	
}
