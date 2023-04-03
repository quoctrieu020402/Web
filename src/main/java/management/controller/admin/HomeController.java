package management.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("abc")
@RequestMapping("/admin/")
public class HomeController {
	@GetMapping("home")
	public ModelAndView Home() {
		ModelAndView modelAndView = new ModelAndView("admin/Home");
		return modelAndView;
	}
}
