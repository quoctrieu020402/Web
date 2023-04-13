package management.controller.admin;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import management.dao.IBillDao;
import management.dao.IStaffDao;
import management.entity.Bill;


@Controller
@RequestMapping("/admin/")

public class OrderController {

	@Autowired
	private IBillDao billDao;
	
	
	@GetMapping("order")
	public ModelAndView bills(ModelMap model) {
		List<Bill>list=billDao.getListBill();
		System.out.println("hello"+list.size());
		model.addAttribute("listBill", list);
		
		ModelAndView modelAndView = new ModelAndView("admin/order");
		return modelAndView;
	}
	
	

}
