package management.dao;

import java.util.List;

import management.entity.Customer;

public interface ICustomerDao {
	Customer createCustomer(Customer customer);
	List<Customer>getListCustomer();
}
