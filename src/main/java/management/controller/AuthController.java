package management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import management.dao.IAccountDao;
import management.entity.Account;
import management.entity.Customer;
import management.entity.Role;

@Controller
public class AuthController {
	
	@Autowired
	private IAccountDao accountDao;
	
	@GetMapping("/user/signup")
	public ModelAndView registerCustomer() {
		ModelAndView mav = new ModelAndView("auth/signup");
		
		Account account = new Account();
		Customer customer = new Customer();
		Role role = new Role();
		
		System.out.println("test1");
		
		account.setEmail("kansan@gmail.com");
		account.setPassword("123456");
		
		role.setName("USER");
		role.setId("USER");
		
		customer.setId("MKH3");
		
		customer.setName("Trieu");
		
		customer.setSurname("Bui");
		
		customer.setAccount(account);
		
		account.setRole(role);
		
		account.setCustomer(customer);
		
		accountDao.createAccountOfCustomer(account);
		
		return mav;
	}
}
