package Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ActionContext;

import Dao.ProductDao;
import domain.Product;
import domain.User;

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao{
	//获得所有商品
	@Override
	public List getAllProduct() {
		/*DetachedCriteria dc = DetachedCriteria.forClass(Product.class);*/
		/*Criteria creteria = getSessionFactory().getcreateCriteria(Product.class);*/
		Criteria creteria = getSessionFactory().getCurrentSession().createCriteria(Product.class);
		List products = creteria.list();
		return products;
		
	}
	//模糊查询
	@Override
	public List<Product> findByInfo(Product product) {
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Product.class);
		if(null!=product.getPname()&&!product.getPname().trim().equals("")) {
			criteria.add(Restrictions.like("pname", "%"+product.getPname()+"%"));
		}
		if(null!=product.getKinds()&&!product.getKinds().trim().equals("")) {
			criteria.add(Restrictions.like("kinds", "%"+product.getKinds()+"%"));
		}
		List<Product> productList = criteria.list();
		System.out.println(productList);
		return productList;
		
		
	}
	//通过用户id查询商品
	@Override
	public List<Product> findByUid(User user) {
		System.out.println(user.getUid());
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		dc.add(Restrictions.eq("uid", user.getUid()));
		List<Product> myproducts = (List<Product>) getHibernateTemplate().findByCriteria(dc);
		System.out.println(myproducts.toString());
		return myproducts;
	}
	//通过商品名删除商品
	@Override
	public void deleteByPname(Product product) {
		String hql = "delete Product where pname=?";
		Session session = super.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		System.out.println("删除的商品名称是"+product.getPname());
		query.setString(0, product.getPname());
		query.executeUpdate();
		
	}
	//添加商品
	@Override
	public void addProduct(Product product) {
		getHibernateTemplate().save(product);
		
	}
	//通过商品id查询商品
	@Override
	public Product findByPid(int pid) {
		System.out.println(pid);
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		dc.add(Restrictions.eq("pid", pid));
		List<Product> products = (List<Product>) getHibernateTemplate().findByCriteria(dc);
		System.out.println(products.toString());
		if(products.size()>0) {
			return products.get(0);
		}else {
			return null;
		}
	}
	//查询总条数
	@Override
	public int getTotalCount() {
		/*Long totalCount = (Long) DetachedCriteria.setProjection(Projections.rowCount())
				.getExecutableCriteria(this.getHibernateTemplate().getSessionFactory().
						getCurrentSession()).uniqueResult();*/
		String hql = "select count(*) from Product";
		Session currentSession = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = currentSession.createQuery(hql);
		Long totalCount = (Long) query.uniqueResult();
		System.out.println("总条数是"+totalCount);
		return totalCount.intValue();
	}
	//获得分页商品数据
	@Override
	public List<Product> findProductListForPageBean(int index, int currentCount) {
		String hql = "from Product";
		Session currentSession = getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = currentSession.createQuery(hql);
		query.setFirstResult(index);
		query.setMaxResults(currentCount);
		List<Product> productList = query.list();
		return productList;
	}
	@Override
	public void updateCount(Product product) {
		getHibernateTemplate().update(product);
		
	}	
}
