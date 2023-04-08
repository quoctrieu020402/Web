package management.dao;

import java.util.List;

import management.entity.Product;

public interface IProductDao {
	List<Product> getProductsIsAcctive(boolean b);
	
	List<Product> getProductsOfCategory(String categoryId);
}
