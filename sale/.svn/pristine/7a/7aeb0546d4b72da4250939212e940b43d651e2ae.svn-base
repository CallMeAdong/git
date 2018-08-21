package Service.Impl;

import java.util.List;

import Dao.ProductCarDao;
import Service.ProductCarService;
import domain.ProductCar;

public class ProductCarServiceImpl implements ProductCarService{
	private ProductCarDao productcardao;
	@Override
	public void addProductToCar(ProductCar productCar) {
		productcardao.addProductToCar(productCar);
		
	}
	public ProductCarDao getProductcardao() {
		return productcardao;
	}
	public void setProductcardao(ProductCarDao productcardao) {
		this.productcardao = productcardao;
	}
	@Override
	public List<ProductCar> findByUid(int uid) {
		return productcardao.findByUid(uid);
	}
	@Override
	public ProductCar findByPid(int pid) {
		return productcardao.findByPid(pid);
		
	}
	
}
