package management.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import management.dao.IBillDao;
import management.entity.Bill;
import management.entity.Customer;


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
	@Override
	public List<Bill> getListBill() {
	Session session = sessionFactory.openSession();
	
	String hgl = "From Bill";
	
	Query query = session.createQuery(hgl);
	
	List<Bill> list = query.list();
	
	return list;
}

}
