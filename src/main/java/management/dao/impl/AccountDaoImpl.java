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
import management.entity.Role;

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
	public Account createAccountOfCustomer(Account account) {
		
		Session s = sessionFactory.openSession();
		
		try {
			
			s.beginTransaction();
			
			Role role = new Role();
			role.setName("USER");
			role.setId("USER");
			
			Long indentity = customerDao.getNumberOfCustomer();
			
			String idCusomer = "MAKH" + (indentity + 1);
			
			account.getCustomer().setId(idCusomer);
			
			account.getCustomer().setAccount(account);
			
			account.setRole(role);
			
			if (!roleDao.existsByName(account.getRole().getName())) {
				
				roleDao.createRole(account.getRole());
				
			}
			
			String saveAccount =  (String) s.save(account);
			
			String saveCustomer =  (String) s.save(account.getCustomer());
			
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
	
	

}
