package mini.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mini.common.Search;
import mini.service.domain.Product;
import mini.service.domain.Purchase;
import mini.service.domain.User;
import mini.service.purchase.PurchaseDao;
import mini.service.purchase.PurchaseService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml" })
public class miniPurchaseTest {
	
	@Autowired
	@Qualifier("purchaseDaoImpl")
	private PurchaseDao purchaseDao;
	
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	
	@Test
	public void testGetPurchase() throws Exception{
		Purchase purchase = new Purchase();
		Assert.assertNotNull(purchaseService.getPurchase(10001));
		System.out.println("*****testGetPurchase 완료*****");
	}
	
	@Test
	public void testAddPurchase() throws Exception{
		Purchase purchase = new Purchase();
		User user = new User();
		user.setUserId("user04");
		Product product = new Product();
		product.setProdNo(10001);
		
		purchase.setPurchaseProd(product);
		purchase.setBuyer(user);
		purchase.setPaymentOption("1");
		purchase.setReceiverName("용");
		purchase.setReceiverPhone("11");
		purchase.setDivyAddr("경기");
		purchase.setDivyRequest("빨리");
		purchase.setDivyDate("12-12-12");
		Assert.assertEquals(1,purchaseService.addPurchase(purchase));
		System.out.println("*****testAddPurchase 완료*****");
	}
	
	@Test
	public void testUpdatePurchase() throws Exception{
		Purchase purchase = new Purchase();
		User user = new User();
		user.setUserId("user04");
		Product product = new Product();
		product.setProdNo(10000);
		purchase.setTranNo(10001);
		purchase.setPurchaseProd(product);
		purchase.setBuyer(user);
		purchase.setPaymentOption("2");
		purchase.setReceiverName("용용");
		purchase.setReceiverPhone("1111");
		purchase.setDivyAddr("경기경기");
		purchase.setDivyRequest("빨리빨리");
		purchase.setDivyDate("11-11-11");
		Assert.assertEquals(1, purchaseService.updatePurchase(purchase));
		System.out.println("*****testUpdatePurchase 완료*****");
	}
	@Test
	public void testGetPurchaseList() throws Exception{
		User user = new User();
		user.setUserId("user04");
		String buyerId=user.getUserId();
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(5);
		
		Assert.assertNotNull(purchaseService.getPurchaseList(search, buyerId).get("list"));
		System.out.println(purchaseService.getPurchaseList(search, buyerId).get("list"));
		System.out.println("*****testGetPurchaseList 완료*****");
	}
	
	
}
