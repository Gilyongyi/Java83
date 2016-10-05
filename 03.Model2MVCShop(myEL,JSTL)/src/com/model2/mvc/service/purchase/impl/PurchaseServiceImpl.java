package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseServiceImpl implements PurchaseService{
	private PurchaseDAO purchaseDAO;
	private ProductDAO productDAO;
	
	public PurchaseServiceImpl(){
		purchaseDAO = new PurchaseDAO();
	}
	
	public void addPurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.insertPurchase(purchaseVO);
	}

	@Override
	public PurchaseVO getPurchase(int tranNo) throws Exception {
		// TODO Auto-generated method stub
		
		return purchaseDAO.findPurchase(tranNo);
	}

	@Override
	public PurchaseVO getPurchase2(int ProdNo) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDAO.findPurchase2(ProdNo);
	}

	@Override
	public HashMap<String, Object> getPurchaseList(SearchVO searchVO, String buyerId) throws Exception {
		// TODO Auto-generated method stub
		return purchaseDAO.getPurchaseList(searchVO,buyerId);
	}

	@Override
	public HashMap<String, Object> getSaleList(SearchVO searchVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
		// TODO Auto-generated method stub
		purchaseDAO.updatePurchase(purchaseVO);
	}

	@Override
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception {
		// TODO Auto-generated method stub
		purchaseDAO.updateTranCode(purchaseVO);
	}

}
