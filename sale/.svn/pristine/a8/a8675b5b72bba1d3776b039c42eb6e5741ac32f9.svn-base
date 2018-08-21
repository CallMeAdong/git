package Action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.Projection;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Service.ProductService;
import domain.Product;
import domain.User;
import net.sf.json.JSONObject;
import vo.PageBean;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	public Product product = new Product();
	private ProductService productservice;
	private String result;
	private File pimg; //得到上传的文件
    private String pimgContentType; //得到文件的类型
    private String pimgFileName; //得到文件的名称
	//获取所有商品
	public String getAllProduct(){
		List<Product> products = productservice.getAllProduct();
		ActionContext.getContext().getSession().put("products", products);
		return "TOHOME";
	}
	//获取条件查询的商品
	public String findByInfo(){
		/*Map<String, Object> parameters = ActionContext.getContext().getParameters();
		System.out.println(parameters);
		System.out.println("商品名称是"+product.getPname());
		System.out.println("商品种类是"+product.getKinds());
		System.out.println("商品是"+product);*/
		List<Product> productslist = productservice.findByInfo(product);
		ActionContext.getContext().getSession().put("productlist", productslist);
		return "TOHOME";
	}
	//获取用户自己上架的物品
	public String findByUid() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		System.out.println(user.toString());
		List<Product> myproductslist = productservice.findByUid(user);
		ActionContext.getContext().getSession().put("myproductlist", myproductslist);
		return "TOMYHOME";
	}
	//通过商品名称下架商品
	public String deleteByPname() {
		System.out.println("商品名称是"+product.getPname());
		productservice.deleteByPname(product);
		return "TOMYHOME";
	}
	//上架商品
	public String addProduct() {
		/*System.out.println("File:"+this.getPimg());
		System.out.println("File:"+product.getPimg());*/
		User user = (User) ActionContext.getContext().getSession().get("user");
		System.out.println("文件名:"+this.getPimgFileName());
	    System.out.println("文件格式:"+this.getPimgContentType());
	    //获取文件夹位置
		//String realPath = ServletActionContext.getServletContext().getRealPath("/WebContent/image");
	    String realPath = "C:\\Users\\Don\\eclipse-workspace\\sale\\WebContent\\image";
	    System.out.println("文件夹位置:"+realPath);
		File file = new File(realPath);
		//获取上传的文件
		File file1 = new File(product.getPimg()) ;
		this.setPimg(file1); 
		System.out.println("文件:"+this.getPimg());
		//创建新的文件名
		pimgFileName = UUID.randomUUID().toString()+pimgFileName;
		System.out.println("新的文件名"+pimgFileName);
		if(!file.exists())file.mkdirs();
		try {
			//保存图片
			FileUtils.copyFile(pimg, new File(file,pimgFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product.setDate(new Date());
		System.out.println("uid:"+user.getUid());
		product.setUid(user.getUid());		
		String path = realPath + "\\"+pimgFileName;
		System.out.println("文件路径:"+path);
		product.setPimg(path);
		productservice.addProduct(product);
		return "TOMYHOME";
	}
	//分页查询
	public String selectProductByLimit() {
		String currentPageStr = ServletActionContext.getRequest().getParameter("currentPage");
		if(currentPageStr == null) currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		int currentCount = 2;
		PageBean pageBean = productservice.findPageBean(currentPage, currentCount);
		ActionContext.getContext().getSession().put("pageBean", pageBean);
		return "TOHOMETEST";
	}
	/*public String deleteByPname() {
		System.out.println("商品名称是"+product.getPname());
		productservice.deleteByPname(product);
		User user = (User) ActionContext.getContext().getSession().get("user");
		System.out.println(user.toString());
		List<Product> myproductslist = productservice.findByUid(user);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("myproductslist", myproductslist);
		JSONObject json = JSONObject.fromObject(map);
		return "TOMYHOME";
	}*/
	public void setProductservice(ProductService productservice) {
		this.productservice = productservice;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public Product getModel() {	
		return product;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public File getPimg() {
		return pimg;
	}
	public void setPimg(File pimg) {
		this.pimg = pimg;
	}
	public String getPimgContentType() {
		return pimgContentType;
	}
	public void setPimgContentType(String pimgContentType) {
		this.pimgContentType = pimgContentType;
	}
	public String getPimgFileName() {
		return pimgFileName;
	}
	public void setPimgFileName(String pimgFileName) {
		this.pimgFileName = pimgFileName;
	}
	
}
