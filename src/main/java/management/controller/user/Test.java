package management.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test {
	@GetMapping("/home")
	public ModelAndView showHome() {
		ModelAndView mav = new ModelAndView("user/Home");
		String test = "abc123";
		return mav;
	}
}
