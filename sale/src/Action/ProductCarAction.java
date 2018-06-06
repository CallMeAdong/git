package Action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Service.ProductCarService;
import Service.ProductService;
import domain.Product;
import domain.ProductCar;
import domain.User;

public class ProductCarAction extends ActionSupport implements ModelDriven<ProductCar>{
	public ProductCar productCar = new ProductCar();
	private ProductCarService productcarservice;
	private ProductService productservice;
	public String addProductToCar() {
		System.out.println("商品id:"+productCar.getPid());
		Product product = productservice.findByPid(productCar.getPid());
		User user = (User) ActionContext.getContext().getSession().get("user");
		//System.out.println(user.getUid());
		System.out.println("商品是:"+product);
		productCar.setInfo(product.getInfo());
		productCar.setKinds(product.getKinds());
		productCar.setPhone(product.getUphone());
		productCar.setPid(product.getPid());
		productCar.setPimg(product.getPimg());
		productCar.setPname(product.getPname());
		productCar.setPrice(product.getPrice());
		productCar.setUid(user.getUid());
		productCar.setSid(product.getUid());
		//判断购物车里有没有该商品
		ProductCar productcar =  productcarservice.findByPid(product.getPid());
		if(productcar == null) {
			productcarservice.addProductToCar(productCar);
			System.out.println("添加成功");
		}else {
			System.out.println("购物车里已经存在该商品");
		}
		List<ProductCar> buyproducts = productcarservice.findByUid(user.getUid());
		ActionContext.getContext().getSession().put("buyproducts", buyproducts);
		return "TOMYPRODUCTCAR";
	}
	@Override
	public ProductCar getModel() {
		return productCar;
	}
	
	public ProductCarService getProductcarservice() {
		return productcarservice;
	}
	public void setProductcarservice(ProductCarService productcarservice) {
		this.productcarservice = productcarservice;
	}
	public ProductService getProductservice() {
		return productservice;
	}
	public void setProductservice(ProductService productservice) {
		this.productservice = productservice;
	}

}
