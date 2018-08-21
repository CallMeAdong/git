package Dao;

import domain.User;
import vo.PageBean;

public interface UserDao {

	User getUserByUname(String uname);

	void addUser(User u);

	boolean findByUname(String uname);

	void pageQuery(PageBean userPageBean);
}
