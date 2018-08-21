package Action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Service.CheckImgService;
import Service.UserService;
import domain.User;
import net.sf.json.JSONObject;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	public User user = new User();
	private UserService userservice;
	private CheckImgService checkimgservice;
	
	//登陆
	public String login() throws Exception {
		System.out.println(user.getUname());
		User u = userservice.getUserByUname(user);
		ActionContext.getContext().getSession().put("user", u);
		return "TOPRODUCT";
	}
	//注册
	public String regist() throws Exception{
			userservice.addUser(user);
			return "TOLOGIN";		
	}
	//判断用户名是否存在
	
	public String isExistUname() {
		HttpServletResponse response = ServletActionContext.getResponse();
		String uname = ServletActionContext.getRequest().getParameter("name");
		String f = "0"; 
		System.out.println(uname);
		boolean isExist = userservice.findByUname(uname);
		System.out.println(isExist);
			//为真，用户名不存在
			if(isExist) {
				f = "1";
			}
			response.setContentType("text/html;charset=utf-8");
			try {
				response.getWriter().print(f);
				System.out.println(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return null;
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
