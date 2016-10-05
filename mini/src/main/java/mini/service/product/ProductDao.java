package mini.service.product;

import java.util.Map;

import mini.common.Search;
import mini.service.domain.Product;

public interface ProductDao {
	
	public Product findProduct(int prodNo) throws Exception;
	
	public Map<String,Object> getProductList(Search search) throws Exception;
		
	public int insertProduct(Product product) throws Exception;
	
	public int updateProduct(Product product) throws Exception;
}
