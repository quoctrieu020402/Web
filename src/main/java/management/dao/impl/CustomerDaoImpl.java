package management.dao.impl;

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
	public List<Customer> getListCustomer() {
		Session session = sessionFactory.openSession();
		String hgl = "From Customer";
		Query query = session.createQuery(hgl);
		List<Customer> list = query.list();
		return list;
		
	}
	
}
