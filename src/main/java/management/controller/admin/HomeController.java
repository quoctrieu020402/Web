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
		System.out.println("hello");
		System.out.println("test");
		System.out.println("test1");
		System.out.println("test2");
		System.out.println("test3");
		System.out.println("test4");
		ModelAndView modelAndView = new ModelAndView("admin/Home");
		return modelAndView;
	}
	
	@GetMapping("staff/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("admin/register");
		return modelAndView;
	}
}
