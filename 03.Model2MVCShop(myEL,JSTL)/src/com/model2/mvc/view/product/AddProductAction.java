package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class AddProductAction extends Action{
	
	public String execute (HttpServletRequest req,HttpServletResponse res) throws Exception{
		ProductVO productVO = new ProductVO();
		productVO.setProdName(req.getParameter("prodName"));
		productVO.setProdDetail(req.getParameter("prodDetail"));
		productVO.setManuDate(req.getParameter("manuDate").replace("-",""));
		productVO.setPrice(Integer.parseInt(req.getParameter("price")));
		productVO.setFileName(req.getParameter("fileName"));
		
		System.out.println(productVO);
		req.setAttribute("productVO", productVO);
		ProductService service = new ProductServiceImpl();
		service.addProduct(productVO);
		
		return "forward:/product/addProductResult.jsp";
		
	}
}
