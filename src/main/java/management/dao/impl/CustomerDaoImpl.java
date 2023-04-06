package management.dao.impl;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import management.dao.ICustomerDao;
import management.entity.Customer;

@Repository  
@Transactional
public class CustomerDaoImpl implements ICustomerDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Customer createCustomer(Customer customer) {
		
		Session s = sessionFactory.openSession();
		
		try {
			
			s.beginTransaction();
			
			String saveCustomer = (String) s.save(customer);
			
			System.out.println(saveCustomer);
			
			System.out.println(saveCustomer);
			
			s.getTransaction().commit();
			
			return null;
		} catch (Exception e) {
			
			System.out.println(e);
			
			s.getTransaction().rollback();
			
		} finally {
			s.close();
		}
		
		return null;
	}

	@Override
	public Long getNumberOfCustomer() {
		
		Session s = sessionFactory.openSession();
		
		String hql = "select count(kh.id) from Customer kh";
		
		Query query = s.createQuery(hql);
		
		Iterator count = query.iterate();
		
		return (Long) count.next();
	}
	
}
