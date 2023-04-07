package management.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import management.dao.IBillDao;

@Repository
@Transactional
public class BillDaoImpl implements IBillDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public long getCountBill() {
		Session session=sessionFactory.openSession();
		Query query = session.createQuery("select count(*) from Bill");
		return (Long)query.uniqueResult();
		
	}

}
