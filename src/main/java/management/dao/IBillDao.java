package management.dao;

import java.util.List;

import management.entity.Bill;


public interface IBillDao {

	long getCountBill() ;
	public List<Bill> getListBill();
}
