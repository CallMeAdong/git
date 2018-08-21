package Dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import Dao.UserDao;
import domain.User;
import vo.PageBean;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

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

	@Override
	public boolean findByUname(String uname) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("uname", uname));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(list.size()>0) {
			System.out.println("该用户名已经存在");
			return false;
		}else {	
			System.out.println("该用户不存在");
			return true;
		}
	}
}
