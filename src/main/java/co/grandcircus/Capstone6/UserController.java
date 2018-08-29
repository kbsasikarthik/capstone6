package co.grandcircus.Capstone6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Capstone6.dao.TaskDao;
import co.grandcircus.Capstone6.dao.UserDao;
import co.grandcircus.Capstone6.entity.User;

@Controller
public class UserController {
	
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/users")
	public ModelAndView listUsers() {
		ModelAndView mav = new ModelAndView("users");
		mav.addObject("users", userDao.findAll());
		return mav;
	}
	
	@RequestMapping("/users/{id}")
	public ModelAndView showUser(@PathVariable("id") User user) {
		ModelAndView mav = new ModelAndView("show-user");
		mav.addObject("user", user);
		mav.addObject("tasks", taskDao.findByOrderByDescription());
		return mav;
	}
	
	@RequestMapping("/users/{id}/edit")
	public ModelAndView editUser(@PathVariable("id") User user) {
		ModelAndView mav = new ModelAndView("edit-user");
		mav.addObject("user", user);
		mav.addObject("tasks", taskDao.findByOrderByDescription());
		return mav;
	}
	
	@RequestMapping(value="/users/{id}/edit", method=RequestMethod.POST)
	public ModelAndView submitEditUser(@ModelAttribute("id") User user) {
		userDao.save(user);
		ModelAndView mav = new ModelAndView("redirect:/users");
		return mav;
	}
	
	@RequestMapping("/users/add")
	public ModelAndView addUser() {
		ModelAndView mav = new ModelAndView("user-add");
		mav.addObject("users", taskDao.findByOrderByDescription());
		return mav;
	}
	
	@RequestMapping(value="/users/add", method=RequestMethod.POST)
	public ModelAndView submitAddUser(User user) {
		userDao.save(user);
		ModelAndView mav = new ModelAndView("redirect:/users");
		return mav;
	}
	
	@RequestMapping("/users/{id}/delete")
	public ModelAndView editUser(@PathVariable("id") Long id) {
//		userDao.deleteById(id);
		ModelAndView mav = new ModelAndView("redirect:/users");
		return mav;
	}
	
	
}
