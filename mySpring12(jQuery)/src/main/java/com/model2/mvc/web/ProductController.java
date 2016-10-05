package com.model2.mvc.web;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.model2.mvc.common.Page;
import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;

	public ProductController() {
		System.out.println("ProductController default Constructor call....");
	}
	
	@RequestMapping("addProduct")
	public String addProduct(@ModelAttribute("product") Product product,
							@RequestParam("uploadFile") MultipartFile file,
							HttpServletRequest req) throws Exception{
		System.out.println("[addProduct start]");
		
		product.setManuDate(req.getParameter("manuDate").replace("-",""));
		if(null!=file){
			String fileName=file.getOriginalFilename();
			product.setFileName(fileName);
		File filefile= new File("C:\\workspace\\mySpring12(jQuery)\\WebContent\\images\\uploadFiles\\"+fileName);
		file.transferTo(filefile);
		}
		productService.addProduct(product);
		req.setAttribute("vo", product);
		System.out.println("[addProduct end]");

		return "/product/addProductResult.jsp";
	}
	
	@RequestMapping("listProduct")
	public String listProduct(	HttpServletRequest req,
								Map<String,Object> map) throws Exception{
		System.out.println("[listProduct start]");
		
		System.out.println(req.getQueryString());
		
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
	
	@RequestMapping("getProduct")
	public String getProduct(@ModelAttribute("product")Product product,
							HttpServletRequest req,HttpServletResponse res) throws Exception{
		System.out.println("[getProduct start]");
		
		Cookie cookie = null;
		String history = null;
		Cookie[] cookies = req.getCookies();
		
		req.setAttribute("vo", productService.getProduct(product.getProdNo()));
		
		if(req.getParameter("menu").equals("manage")){
			return "/product/updateProduct.jsp";
		}else{
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				history = cookie.getValue();
				if (cookie.getName().equals("history")) {
					if (!(history.contains("" + product.getProdNo()))) {
						history += "," + product.getProdNo();
					}
				}
			}

			if (cookie.getName().equals("history")) {
				cookie = new Cookie("history", history);
			} else {
				cookie = new Cookie("history", "" + product.getProdNo());
			}
			cookie.setMaxAge(-1);
			cookie.setPath("/");
			res.addCookie(cookie);
			
			System.out.println("[getProduct end]");
			return "/product/getProduct.jsp";

		}
	}
	
	@RequestMapping(value="updateProduct",method=RequestMethod.GET)
	public String updateProduct(@ModelAttribute("product")Product product){
		System.out.println("[updateProduct() start]");
				
		System.out.println("[updateProduct() end");
		return "/product/updateProduct.jsp";
	}
	
	@RequestMapping(value="updateProduct",method=RequestMethod.POST )
	public String updateProduct(@ModelAttribute("product")Product product,
								@RequestParam("uploadFile") MultipartFile file,
								HttpServletRequest req,HttpSession session) throws Exception{
		System.out.println("[updateProduct() start]");
		product.setManuDate(product.getManuDate().replace("-",""));
		if(null!=file){
			String fileName=file.getOriginalFilename();
			product.setFileName(fileName);
		File filefile= new File("C:\\workspace\\mySpring12(jQuery)\\WebContent\\images\\uploadFiles\\"+fileName);
		file.transferTo(filefile);
		}
		productService.updateProduct(product); 
		
		System.out.println("[updateProduct() end");
		return "/product/listProduct?menu=manage";
	}
	
	@RequestMapping("deleteProduct")
	public String deleteProduct(@ModelAttribute("product")Product product) throws Exception{
		System.out.println("deleteProduct() start");
		productService.deleteProduct(product.getProdNo());
		System.out.println("deleteProduct() end");
		return "/product/listProduct?menu=manage";
	}
}
