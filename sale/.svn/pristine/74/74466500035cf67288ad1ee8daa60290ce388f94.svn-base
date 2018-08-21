package Service;

import java.util.List;

import domain.Product;
import domain.User;
import vo.PageBean;

public interface ProductService {

	List<Product> getAllProduct();

	List<Product> findByInfo(Product product);

	List<Product> findByUid(User user);

	void deleteByPname(Product product);

	void addProduct(Product product);

	Product findByPid(int pid);
	
	PageBean findPageBean(int currentPage,int currentCount);
}
