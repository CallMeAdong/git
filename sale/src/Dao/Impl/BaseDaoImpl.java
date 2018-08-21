package Dao.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import Dao.BaseDao;
import vo.PageBean;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	//代表某个实体的类型
	private Class<T> entityClass;
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	//在父类（BaseDaoImpl）的构造方法中动态获得entityClass
	public BaseDaoImpl() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得父类上声明的泛型数组
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}
	@Override
	public void save(T entity) {
		getHibernateTemplate().save(entity);
		
	}

	@Override
	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
		
	}

	@Override
	public T findById(Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		return (List<T>) session.createCriteria(entityClass);
	}

	@Override
	public void executeUpdate(String queryName, Object... objects) {
		Session session = this.getSessionFactory().getCurrentSession();
		System.out.println(Thread.currentThread().getName());
		Query query = session.getNamedQuery(queryName);
		System.out.println(query.toString());
		int i = 0;
		for (Object object : objects) {
			//为HQL语句中的？赋值
			query.setParameter(i++, object);
		}
		//执行更新
		query.executeUpdate();
		
	}

	@Override
	public void pageQuery(PageBean PageBean) {
		int currentPage = PageBean.getCurrentPage();
		int pageSize = PageBean.getPageSize();
		DetachedCriteria detachedcriteria = PageBean.getDetachedcriteria();
		detachedcriteria.setProjection(Projections.rowCount());
		List<Long> countlist = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedcriteria);
		Long count = countlist.get(0);
		PageBean.setTotal(count.intValue());
		detachedcriteria.setProjection(null);
		int firstResult = (currentPage - 1) * pageSize;
		int maxResults = pageSize;
		List rows = this.getHibernateTemplate().findByCriteria(detachedcriteria, firstResult, maxResults);
		PageBean.setRows(rows);
		
	}

}
