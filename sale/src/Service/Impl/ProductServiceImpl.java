package Service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import Dao.ProductDao;
import Service.ProductService;
import domain.Product;
import domain.User;
import vo.ProductPageBean;

public class ProductServiceImpl implements ProductService{
	private ProductDao pd;
	public void setPd(ProductDao pd) {
		this.pd = pd;
	}
	@Override
	public List<Product> getAllProduct() {
		List<Product> products = pd.getAllProduct();
		return products;
	}
	@Override
	public List<Product> findByInfo(Product product) {
		List<Product> products = pd.findByInfo(product);
		return products;
	}
	@Override
	public List<Product> findByUid(User user) {
		List<Product> products = pd.findByUid(user);
		return products;
	}
	@Override
	public void deleteByPname(Product product) {
		pd.deleteByPname(product);
		
	}
	@Override
	public void addProduct(Product product) {
		/*System.out.println(product.getPimg());
		String file = product.getPimg();
		product.setDate(new Date());
		if(file!=null) {
			//生成一个随机文件名
			Random rand = new Random();
			int random = rand.nextInt();
			random = random > 0 ? random : (-1) * random;
			//获取当前时间
			Date date = new Date();
			//将时间转换格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String currentTime = sdf.format(date);
			//设置文件名（新文件名=当前时间+随机数+上传文件的后缀名）
			String imageFileName = currentTime+random;
			String newName = imageFileName + fileFileN
		}
		//1.获取文件上传路径
		//2.获取服务器存放文件夹位置
*/		pd.addProduct(product);
		
	}
	@Override
	public Product findByPid(int pid) {
		return pd.findByPid(pid);
		
	}
	@Override
	public ProductPageBean findPageBean(int currentPage, int currentCount) {
		//目的：就是想办法封装一个PageBean 并返回
				ProductPageBean pageBean = new ProductPageBean();
				//1、当前页private int currentPage;
				pageBean.setCurrentPage(currentPage);
				//2、当前页显示的条数private int currentCount;
				pageBean.setCurrentCount(currentCount);
				//3、总条数private int totalCount;
				int totalCount = pd.getTotalCount();
				pageBean.setTotalCount(totalCount);
				//4、总页数private int totalPage;
				/*
				 * 总条数		当前页显示的条数	总页数
				 * 10		4				3
				 * 11		4				3
				 * 12		4				3
				 * 13		4				4
				 * 
				 * 公式：总页数=Math.ceil(总条数/当前显示的条数)
				 * 
				 */
				int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
				pageBean.setTotalPage(totalPage);
				//5、每页显示的数据private List<T> productList = new ArrayList<T>();
				/*
				 * 页数与limit起始索引的关系
				 * 例如 每页显示4条
				 * 页数		其实索引		每页显示条数
				 * 1		0			4
				 * 2		4			4
				 * 3		8			4
				 * 4		12			4
				 * 
				 * 索引index = (当前页数-1)*每页显示的条数
				 * 
				 */
				int index = (currentPage-1)*currentCount;
				
				List<Product> productList = pd.findProductListForPageBean(index,currentCount);
				pageBean.setProductList(productList);
				
				return pageBean;
	}
	@Override
	public void updateCount(Product product) {
		pd.updateCount(product);
		
	}

}
