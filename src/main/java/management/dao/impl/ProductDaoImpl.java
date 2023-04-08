package management.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import management.dao.IProductDao;
import management.entity.Product;

@Repository  
@Transactional
public class ProductDaoImpl implements IProductDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProductsIsAcctive(boolean b) {
		
		Session s = sessionFactory.openSession();
		
		String hql = "select sp from Product sp where sp.status = ?";
		
		Query query = s.createQuery(hql);
		
		query.setParameter(0, b);
		
		return query.list();
	}

	@Override
	public List<Product> getProductsOfCategory(String categoryId) {
		
		Session s = sessionFactory.openSession();
		
		String hql = "select sp from Product sp where sp.category.id = ?";
		
		Query query = s.createQuery(hql);
		
		query.setParameter(0, categoryId);
		
		return query.list();
	}

}
