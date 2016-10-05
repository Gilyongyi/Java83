package com.model2.mvc.service.puchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;

@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDao{
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass()+".setSqlSession() Call.....");
		this.sqlSession = sqlSession;
	}
	public PurchaseDaoImpl(){
		System.out.println("::"+getClass()+" default Constructor Call....");
	}
	
	public Purchase findPurchase(int tranNo) throws Exception{
		return sqlSession.selectOne("PurchaseMapper.getPurchase",tranNo);
	}
	
	public int insertPurchase(Purchase purchase)throws Exception{
		return sqlSession.insert("PurchaseMapper.addPurchase",purchase);
	}
	
	public int updatePurchase(Purchase purchase) throws Exception{
		return sqlSession.update("PurchaseMapper.updatePurchase",purchase);
	}

	public Map<String,Object> getPurchaseList(Map<String,Object> map) throws Exception {
		List<Purchase> list = sqlSession.selectList("PurchaseMapper.getPurchaseList", map);
		map.put("count", sqlSession.selectOne("PurchaseMapper.getTotalCount",map));
		map.put("list", list);
		System.out.println("여기는 리스트:::::::::"+list);
		return map;
	}
	
/*	public Map<String,Object> getSesPurchaseList(Map<String,Object> map) throws Exception {
		List<Purchase> list = sqlSession.selectList("PurchaseMapper.getSesPurchaseList", map);
		map.put("count", sqlSession.selectOne("PurchaseMapper.getTotalCount",map));
		map.put("list", list);
		return map;
	}*/
	
	public Purchase findPurchase2(int prodNo) throws Exception{
		return sqlSession.selectOne("PurchaseMapper.getPurchase2",prodNo);
	}
	

	public int updateTranCode(Purchase purchase) throws Exception{
		return sqlSession.update("PurchaseMapper.updateTranCode",purchase);
	}
	
	public int deletePurchase(int tranNo) throws Exception{
		return sqlSession.delete("PurchaseMapper.deletePurchase",tranNo);
	}

}
