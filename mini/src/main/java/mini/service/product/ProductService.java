package mini.service.product;

import java.util.Map;

import mini.common.Search;
import mini.service.domain.Product;

public interface ProductService {
	
	public int addProduct(Product productVO) throws Exception;

	public Product getProduct(int prodNo) throws Exception;

	public Map<String,Object> getProductList(Search search) throws Exception;

	public int updateProduct(Product product) throws Exception;
	
}