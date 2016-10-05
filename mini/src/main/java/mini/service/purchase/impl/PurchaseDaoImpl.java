package mini.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mini.common.Search;
import mini.service.domain.Purchase;
import mini.service.purchase.PurchaseDao;

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

	public Map<String,Object> getPurchaseList(Search search,String buyerId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("buyer", buyerId);
		map.put("search", search);
		List<Purchase> list = sqlSession.selectList("PurchaseMapper.getPurchaseList", map);
			
		map.put("list", list);
		return map;
	}
	/*
	public Purchase findPurchase2(int prodNo) throws Exception{
		return null;
	}
	

	public int updateTranCode(Purchase purchase) throws Exception{
		return 0;
	}*/

}
