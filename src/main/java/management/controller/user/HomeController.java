package management.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(path = {"home","home/{cateogryId}"})
	public ModelAndView showHome(@PathVariable(name = "cateogryId", required = false) String caterogyId) {
		ModelAndView mav = new ModelAndView("user/Home");
		
		List<Category> listOfCategory = categoryDao.getCategoriesIsAcctive(true);
		
		mav.addObject("listOfCategory", listOfCategory);
		
		List<Product> listOfProduct = new ArrayList<Product>();
		
		if ( caterogyId != null) {
			
			listOfProduct = productDao.getProductsOfCategory(caterogyId);
			
		} else {
			
			
			listOfProduct = productDao.getProductsIsAcctive(true);
			
		}
		
		mav.addObject("listOfProduct", listOfProduct);
		
		
		return mav;
	}
	
}
