package Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Service.CheckImgService;
import Service.UserService;
import domain.User;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	public User user = new User();
	private UserService userservice;
	private CheckImgService checkimgservice;
	//登陆
	public String login() throws Exception {
		User u = userservice.getUserByUname(user);
		ActionContext.getContext().getSession().put("user", u);
		return "TOPRODUCT";
	}
	//注册
	public String regist() throws Exception{
		System.out.println(user);
		//注册码
		/*checkimgservice.init();
		checkimgservice.check();*/
		userservice.addUser(user);
		return "TOLOGIN";
	}
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public void setCheckimgservice(CheckImgService checkimgservice) {
		this.checkimgservice = checkimgservice;
	}
}
