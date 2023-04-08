package management.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import management.dao.ICategoryDao;
import management.dao.IProductDao;
import management.entity.Category;
import management.entity.Product;

@Controller
@RequestMapping("/user/")
public class HomeController {
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Autowired
	private IProductDao productDao;
	
	@GetMapping("home")
	public ModelAndView showHome() {
		ModelAndView mav = new ModelAndView("user/Home");
		
		List<Category> listOfCategory = categoryDao.getCategoriesIsAcctive(true);
		
		List<Product> listOfProduct = productDao.getProductIsAcctive(true);
		
		mav.addObject("listOfCategory", listOfCategory);
		
		mav.addObject("listOfProduct", listOfProduct);
		
		System.out.println(listOfProduct.size());
		
		return mav;
	}
	
}
