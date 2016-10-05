package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;


@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
		
	public void setSqlSession(SqlSession sqlSession){
		System.out.println("::"+getClass()+".setSqlSession() Call.....");
		this.sqlSession = sqlSession;
	}
	
	public ProductDaoImpl() {
		System.out.println("::"+getClass()+" default Constructor Call....");
	}
	public int insertProduct(Product product) throws Exception {
		return sqlSession.insert("ProductMapper.addProduct",product);
	}
	
	public Product findProduct(int prodNo) throws Exception{
		return sqlSession.selectOne("ProductMapper.getProduct",prodNo);
	}
	
	public Map<String,Object> getProductList(Search search) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
			
		List<Product> list = sqlSession.selectList("ProductMapper.getProductList", search);
			
		map.put("list", list);
		map.put("count", sqlSession.selectOne("ProductMapper.getTotalCount",search));
		return map;
	}
	public int updateProduct(Product product) throws Exception{
		return sqlSession.update("ProductMapper.updateProduct",product);
	}
	
	public int deleteProduct(int prodNo) throws Exception{
		return sqlSession.delete("ProductMapper.deleteProduct",prodNo);
	}
}
