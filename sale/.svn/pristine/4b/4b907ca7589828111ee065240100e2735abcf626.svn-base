package Dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import Dao.ProductCarDao;
import Dao.ProductDao;
import domain.Product;
import domain.ProductCar;

public class ProductCarDaoImpl extends HibernateDaoSupport implements ProductCarDao{

	@Override
	public void addProductToCar(ProductCar productCar) {
		getHibernateTemplate().save(productCar);
		
	}

	@Override
	public List<ProductCar> findByUid(int uid) {
		System.out.println(uid);
		DetachedCriteria dc = DetachedCriteria.forClass(ProductCar.class);
		dc.add(Restrictions.eq("uid", uid));
		List<ProductCar> buyproducts = (List<ProductCar>) getHibernateTemplate().findByCriteria(dc);
		System.out.println(buyproducts.toString());
		return buyproducts;
	}

	@Override
	public ProductCar findByPid(int pid) {
		DetachedCriteria dc = DetachedCriteria.forClass(ProductCar.class);
		dc.add(Restrictions.eq("pid", pid));
		List<ProductCar> products = (List<ProductCar>) getHibernateTemplate().findByCriteria(dc);
		if(products.size()>0) {
			return products.get(0);
		}else {
			return null;
		}
	}

}
