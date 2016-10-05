package com.model2.mvc.service.puchase.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;

@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	@Qualifier("purchaseDaoImpl")
	PurchaseDao purchaseDao;
	
	public void setPurchaseDao(PurchaseDao purchaseDao) {
		System.out.println("::"+getClass()+".setUserDao Call....");
		this.purchaseDao = purchaseDao;
	}
	
	public Purchase getPurchase(int tranNo) throws Exception{
		return purchaseDao.findPurchase(tranNo);
	}
	public int addPurchase(Purchase purchase) throws Exception{
		return purchaseDao.insertPurchase(purchase);
	}
	public int updatePurchase(Purchase purchase) throws Exception{
		return purchaseDao.updatePurchase(purchase);
	}
	
	public Map<String,Object> getPurchaseList(Search search,String buyerId) throws Exception{
		Map<String,Object> map = new HashMap();
		map.put("search", search);
		map.put("buyer", buyerId);
		return purchaseDao.getPurchaseList(map);
	}
	
	/*public Map<String,Object> getSesPurchaseList(Search search,String buyerId) throws Exception{
		Map<String,Object> map = new HashMap();
		map.put("search", search);
		map.put("buyer", buyerId);
		return purchaseDao.getPurchaseList(map);
	}*/
	
	public int updateTranCode(Purchase purchase) throws Exception{
		return purchaseDao.updateTranCode(purchase);
	}
	public Purchase getPurchase2(int prodNo) throws Exception{
		return purchaseDao.findPurchase2(prodNo);
	}
	public int deletePurchase(int tranNo) throws Exception{
		return purchaseDao.deletePurchase(tranNo);
	}
	/*
	public Map<String,Object> getSaleList(Search search) throws Exception{
		return null;
	}*/
	
	
	
}