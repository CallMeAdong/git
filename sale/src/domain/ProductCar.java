package domain;

public class ProductCar {
	private int uid;//买家id
	private int sid;//卖家id
	private int pid;//商品id
	private String pname;//商品名称
	private double price;//商品价格
	private String pimg;//商品图片
	private String kinds;//商品种类
	private String phone;//卖家电话
	private String info;//商品信息
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "ProductCar [uid=" + uid + ", sid=" + sid + ", pid=" + pid + ", pname=" + pname + ", price=" + price
				+ ", pimg=" + pimg + ", kinds=" + kinds + ", phone=" + phone + ", info=" + info + "]";
	}
	
	
}
