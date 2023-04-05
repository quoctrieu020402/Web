package management.dao;

import management.entity.Account;
import management.entity.Customer;

public interface IAccountDao {
	Account createAccountOfCustomer(Account account);
}
