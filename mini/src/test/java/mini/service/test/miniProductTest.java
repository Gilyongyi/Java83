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
import mini.service.product.ProductDao;
import mini.service.product.ProductService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:config/context-common.xml",
		"classpath:config/context-aspect.xml",
		"classpath:config/context-mybatis.xml",
		"classpath:config/context-transaction.xml" })
public class miniProductTest {
	
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	
	@Test
	public void testAddProduct() throws Exception{
		Product product = new Product("갤럭시노트5","126666",123,"900000","모름");
		Assert.assertEquals(1,productService.addProduct(product));
		System.out.println("*****testAddProduct 완료*****");
	}
	
	@Test
	public void testGetProduct() throws Exception{
		Assert.assertNotNull(productService.getProduct(10020));
		System.out.println("*****testGetProduct 완료*****");
	}
	
	@Test
	public void testUpdateProduct() throws Exception{
		Product product = new Product("갤럭시노트7","444444",456,"600000","ddd");
		product.setProdNo(10020);
		Assert.assertEquals(1, productService.updateProduct(product));
		System.out.println("*****testUpdateProduct 완료*****");
	}
		
	@Test
	public void testGetProductList() throws Exception{
		Search search = new Search();
		search.setCurrentPage(1);
		search.setPageSize(5);
		search.setSearchCondition("1");
		search.setOrder("desc");
		search.setSearchKeyword("정환정환");
		Assert.assertNotNull(productService.getProductList(search).get("list"));
		System.out.println(productService.getProductList(search).get("list"));
		System.out.println("*****testGetProductList 완료*****");
	}
	
	
}
