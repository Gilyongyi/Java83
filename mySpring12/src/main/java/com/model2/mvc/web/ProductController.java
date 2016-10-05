package com.model2.mvc.web;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.model2.mvc.service.product.ProductService;

@Controller
public class ProductController {
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	public ProductController() {
		System.out.println("ProductController default Constructor call....");
	}
	
	@RequestMapping("/addProduct.do")
	public String addProduct(@ModelAttribute("product") Product product,
							HttpServletRequest req) throws Exception{
		System.out.println("[addProduct start]");
		product.setManuDate(product.getManuDate().replace("-",""));
		productService.addProduct(product);
		System.out.println("[addProduct end]");

		return "/product/addProductResult.jsp";
	}
	
	@RequestMapping("/listProduct.do")
	public String listProduct(	HttpServletRequest req,
								Map<String,Object> map) throws Exception{
		System.out.println("[listProduct start]");

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
		
		map=productService.getProductList(search);
		
		int totalCount=0;
		ArrayList<Product> list=null;
		if(map != null){
			totalCount=((Integer)map.get("count")).intValue();
			list=(ArrayList<Product>)map.get("list");
		}
		Page resultPage	= 
				new Page( currentPage, totalCount, pageUnit, pageSize);
		
		page.setCurrentPage(currentPage);
		page.setPageSize(pageSize);
		page.setPageUnit(pageUnit);
		page.setTotalCount(totalCount);
		
		req.setAttribute("page", resultPage);
		req.setAttribute("list", list);
		req.setAttribute("search", search);
		
		System.out.println("[listProduct end]");
		return "/product/listProduct.jsp";
	}
	
	@RequestMapping("/getProduct.do")
	public String getProduct(@ModelAttribute("product")Product product,
							HttpServletRequest req,HttpServletResponse res) throws Exception{
		System.out.println("[getProduct start]");
		
		req.setAttribute("vo", productService.getProduct(product.getProdNo()));
		
		if(req.getParameter("menu").equals("manage")){
			return "/product/updateProduct.jsp";
		}else{
			String A=req.getParameter("prodNo");
			Cookie[] cookies = req.getCookies();
			String B = null;
			if(cookies!=null){
				for(int i=0;i<cookies.length;i++){
					String name = cookies[i].getName();
					String value = cookies[i].getValue();
					
					if(name.equals("history")){
						B =value;
					}
				}
			}
			B+=(","+A);
			Cookie cookie = new Cookie("history",B);
			cookie.setMaxAge(60*30);
			res.addCookie(cookie);
			System.out.println("쿠키 저장 완료");
			System.out.println("[getProduct end]");
			return "/product/getProduct.jsp";

		}
	}
	
	@RequestMapping(value="/updateProduct.do",method=RequestMethod.GET)
	public String updateProduct(@ModelAttribute("product")Product product){
		System.out.println("[updateProduct() start]");
				
		System.out.println("[updateProduct() end");
		return "/product/updateProduct.jsp";
	}
	
	@RequestMapping(value="/updateProduct.do",method=RequestMethod.POST )
	public String updateProduct(@ModelAttribute("product")Product product,
								HttpServletRequest req,HttpSession session) throws Exception{
		System.out.println("[updateProduct() start]");
		
		req.setAttribute("product", productService.updateProduct(product)); 
		
		System.out.println("[updateProduct() end");
		return "/product/updateProductView.jsp";
	}
}
