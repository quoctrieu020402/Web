package management.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import management.dao.IAccountDao;
import management.dao.ICustomerDao;
import management.dao.IRoleDao;
import management.entity.Account;

@Repository  
@Transactional
public class AccountDaoImpl implements IAccountDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ICustomerDao customerDao;
	
	@Autowired
	private IRoleDao roleDao;

	@Override
	public Account createCustomer(Account account) {
		
		Session s = sessionFactory.openSession();
		
		try {
			
			s.beginTransaction();
			
			if (!roleDao.existsByName(account.getRole().getName())) {
				
				roleDao.createRole(account.getRole());
				
			}
			
			String saveAccount =  (String) s.save(account);
			
			String saveCustomer =  (String) s.save(account.getCustomer());
			
			System.out.println(saveAccount);
			
			System.out.println(saveCustomer);
			
			s.getTransaction().commit();
			
			return saveAccount;
			
		} catch (Exception e) {
			System.out.println(e);
			s.getTransaction().rollback();
			
		} finally {
			s.close();
		}
		
		return null;
	}
	
	

}
