package co.grandcircus.Capstone6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.Capstone6.dao.TaskDao;
import co.grandcircus.Capstone6.dao.UserDao;
import co.grandcircus.Capstone6.entity.Task;
import co.grandcircus.Capstone6.entity.User;

@Controller
public class TaskController {
	
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserDao userDao;
	
//	@RequestMapping("/")
//	public ModelAndView login() {
//		return new ModelAndView("login");
//	}
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("index");
//		mav.addObject("message", "Welcome to Capstone6");
//		return mav;
	}
	
	@RequestMapping("/tasks")
	public ModelAndView listTasks(@SessionAttribute(name="user", required=false)User user, RedirectAttributes redir) {
		if(user == null) {
			redir.addFlashAttribute("message","Please login to view your tasks");
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav =  new ModelAndView("tasks");
		mav.addObject("tasks", taskDao.findAll());
		return mav;	
	}
	
	@RequestMapping("/tasks/{id}")
	public ModelAndView showTasks(@PathVariable("id") Task task) {
		ModelAndView mav = new ModelAndView("show-task");
		mav.addObject("task", task);
		return mav;	
	}
	
	@RequestMapping("/tasks/{id}/edit")
	public ModelAndView editTasks(@PathVariable("id") Task task) {
		ModelAndView mav = new ModelAndView("task-edit");
		mav.addObject("task", task);
		return mav;	
	}
	
	@RequestMapping(value="/tasks/{id}/edit", method=RequestMethod.POST)
	public ModelAndView submitEditTasks(@ModelAttribute("id") Task task) {
		taskDao.save(task);
		ModelAndView mav = new ModelAndView("redirect:/tasks/" + task.getId());
		return mav;	
	}
	
	@RequestMapping("/tasks/add")
	public ModelAndView addTasks() {
		ModelAndView mav = new ModelAndView("task-add");
		return mav;	
	}
	
	@RequestMapping(value="/tasks/submitadd", method=RequestMethod.POST)
	public ModelAndView submitAddTasks(Task task) {
		taskDao.save(task);
		ModelAndView mav = new ModelAndView("redirect:/tasks");
		return mav;	
	}
	
	@RequestMapping("/tasks/{id}/delete")
	public ModelAndView editTasks(@PathVariable("id") Long id) {
		taskDao.deleteById(id);
		ModelAndView mav = new ModelAndView("redirect:/tasks");
		return mav;	
	}
	
	@RequestMapping("/tasks/{id}/remove-user")
	public ModelAndView removeUser(@PathVariable("id") Long taskid, @RequestParam("id") User user) {
		user.setTasks(null);
		userDao.save(user);
		ModelAndView mav = new ModelAndView("redirect:/tasks" + taskid );
		return mav;	
	}
	
	
	


}
