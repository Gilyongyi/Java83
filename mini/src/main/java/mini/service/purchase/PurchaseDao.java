package mini.service.purchase;

import java.util.Map;

import mini.common.Search;
import mini.service.domain.Purchase;

public interface PurchaseDao {
	
	public int insertPurchase(Purchase purchase)throws Exception;
	
	public int updatePurchase(Purchase purchase) throws Exception;

	public Purchase findPurchase(int tranNo) throws Exception;
	
	//public Purchase findPurchase2(int prodNo) throws Exception;
		
	public Map<String,Object> getPurchaseList(Search search,String buyerId) throws Exception;

	//public int updateTranCode(Purchase purchase) throws Exception;

}
