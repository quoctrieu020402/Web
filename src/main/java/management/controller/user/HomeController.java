package management.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user/")
public class HomeController {
	
	@GetMapping("home")
	public ModelAndView showHome() {
		ModelAndView mav = new ModelAndView("user/Home");
		return mav;
	}
	
	@GetMapping("detailsproduct")
	public ModelAndView showDetailsProduct() {
		ModelAndView mav = new ModelAndView("user/DetailsProduct");
		return mav;
	}
	
	
}
