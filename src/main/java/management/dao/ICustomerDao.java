package management.dao;

import management.entity.Customer;

public interface ICustomerDao {
	Customer createCustomer(Customer customer);
	Long getNumberOfCustomer();
}
