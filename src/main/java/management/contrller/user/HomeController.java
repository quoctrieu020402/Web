package management.contrller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user/home")
public class HomeController {
	
	@GetMapping("")
	public ModelAndView showHome() {
		return null;
	}
}
