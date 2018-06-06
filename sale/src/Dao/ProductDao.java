package Dao;

import java.util.List;

import domain.Product;
import domain.User;

public interface ProductDao {

	List getAllProduct();

	List<Product> findByInfo(Product product);

	List<Product> findByUid(User user);

	void deleteByPname(Product product);

	void addProduct(Product product);
	
	Product findByPid(int pid);
	
	int getTotalCount();
	
	List<Product> findProductListForPageBean(int index,int currentCount);
}
