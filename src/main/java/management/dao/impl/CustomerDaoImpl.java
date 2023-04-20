package management.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
	public Customer createCustomer(final Customer customer) {
		
		Session s = sessionFactory.openSession();
		
		try {
			
			s.beginTransaction();
			
			String saveCustomer = (String) s.save(customer);
			
			
			
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
	public List<Customer> Getlist_Customer()
	{
		List<Customer> list = new ArrayList<>();
		try {
			Session session = sessionFactory.openSession();
			String hqlString="FROM Customer";
			Query query = session.createQuery(hqlString);
			 list = query.list();
			 session.close();
		} catch (Exception e) {
			System.out.println("63_Customer");
		}
		return list;
	}
}
