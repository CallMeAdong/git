package Service.Impl;

import com.opensymphony.xwork2.ActionContext;

import Dao.UserDao;
import Service.UserService;
import domain.User;

public class UserServiceImpl implements UserService{
	private UserDao ud;
	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	@Override
	public User getUserByUname(User user) {
		User u = ud.getUserByUname(user.getUname());
		if(u == null) {
			throw new RuntimeException("用户名不存在");
		}
		if(!user.getPwd().equals(u.getPwd())) {
			throw new RuntimeException("密码错误"); 
		}
		System.out.println(u);
		return u;
	}
	@Override
	public void addUser(User u) {
		ud.addUser(u);
	}

}
