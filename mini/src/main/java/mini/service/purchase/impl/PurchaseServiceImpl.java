package mini.service.purchase.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mini.common.Search;
import mini.service.domain.Purchase;
import mini.service.purchase.PurchaseDao;
import mini.service.purchase.PurchaseService;

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
		return purchaseDao.getPurchaseList(search, buyerId);
	}
	/*public Purchase getPurchase2(int ProdNo) throws Exception{
		return null;
	}
	
	public Map<String,Object> getSaleList(Search search) throws Exception{
		return null;
	}
	
	
	public int updateTranCode(Purchase purchase) throws Exception{
		return 0;
	}*/
}