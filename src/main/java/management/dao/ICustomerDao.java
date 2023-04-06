package management.dao;

import java.util.List;

import management.entity.Customer;

public interface ICustomerDao {
	Customer createCustomer(Customer customer);
<<<<<<< HEAD
	Long getNumberOfCustomer();
=======
	List<Customer>getListCustomer();
>>>>>>> branch 'master' of https://github.com/quoctrieu020402/Web.git
}
