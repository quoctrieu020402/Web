package management.dao.impl;

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
			
			Customer saveCustomer = (Customer) s.save(customer);
			
			s.getTransaction().commit();
			
			return saveCustomer;
		} catch (Exception e) {
			System.out.println(e);
			s.getTransaction().rollback();
			
		} finally {
			s.close();
		}
		
		return null;
	}
	
}
