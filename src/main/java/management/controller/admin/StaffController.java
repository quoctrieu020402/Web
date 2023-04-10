package management.controller.admin;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import management.dao.IStaffDao;
import management.entity.Staff;

@Controller
@RequestMapping("/admin/")

public class StaffController {

	@Autowired
	private IStaffDao staffDao;
	
	
	@GetMapping("staff")
	public ModelAndView staff(ModelMap model) {
		List<Staff>list=staffDao.getListStaff();
		System.out.println("hello"+list.size());
		model.addAttribute("listStaff", list);
		
		ModelAndView modelAndView = new ModelAndView("admin/staffs");
		return modelAndView;
	}
}
