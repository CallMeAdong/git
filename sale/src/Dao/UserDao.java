package Dao;

import domain.User;

public interface UserDao {

	User getUserByUname(String uname);

	void addUser(User u);

	
}
