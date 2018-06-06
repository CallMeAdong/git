package Dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import Dao.UserDao;
import domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@Override
	public User getUserByUname(String uname) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("uname", uname));
		List<User> user = (List<User>) getHibernateTemplate().findByCriteria(dc);
		System.out.println(user);
		if(user!=null&&user.size()>0) {
			return user.get(0);
		}else {
			return null;
		}
	}

	@Override
	public void addUser(User u) {
		getHibernateTemplate().save(u);
		
	}
	
}
