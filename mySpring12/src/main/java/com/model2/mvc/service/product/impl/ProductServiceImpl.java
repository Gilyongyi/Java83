package com.model2.mvc.service.product.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;


@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	@Qualifier("productDaoImpl")
	ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		System.out.println("::"+getClass()+".setUserDao Call....");
		this.productDao = productDao;
	}

	public int addProduct(Product product) throws Exception{
		return productDao.insertProduct(product);
	}
	public Product getProduct(int prodNo) throws Exception{
		return productDao.findProduct(prodNo);	
	}
	public Map<String,Object> getProductList(Search search) throws Exception{
		return productDao.getProductList(search);
	}
	public int updateProduct(Product product) throws Exception{
		return productDao.updateProduct(product);
	}
	
}