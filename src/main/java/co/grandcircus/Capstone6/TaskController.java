package co.grandcircus.Capstone6;

import java.util.List;

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
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("message", "Welcome to Capstone6");
		return mav;
	}
	
	@RequestMapping("/tasks")
	public ModelAndView listTasks(@SessionAttribute(name="user", required=false)User user, RedirectAttributes redir) {
		if(user == null) {
			redir.addFlashAttribute("message","Please login to view your tasks");
			return new ModelAndView("redirect:/");
		}
		ModelAndView mav =  new ModelAndView("tasks");
//		List<Task> tasks = taskDao.findAllByUser(user);
//		System.out.println(tasks);
		mav.addObject("tasks", taskDao.findAllByUser(user));
		return mav;	
	}
	
	@RequestMapping("/tasks/{id}")
	public ModelAndView showTasks(@SessionAttribute(name="user", required=false)User user,@PathVariable("id") Task task) {
		ModelAndView mav = new ModelAndView("taskform");
		mav.addObject("task", task);
		return mav;	
	}
	
	@RequestMapping("/tasks/{id}/edit")
	public ModelAndView editTasks(@SessionAttribute(name="user", required=false)User user, @PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("taskform");
		mav.addObject("task", taskDao.findById(id).get());
		mav.addObject("title", "Edit Task");
		return mav;	
	}
	
	@RequestMapping(value="/tasks/{id}/edit", method=RequestMethod.POST)
	public ModelAndView submitEditTasks(@SessionAttribute(name="user", required=false)User user,Task task, @PathVariable("id") Long id) {
//		task.setId(id);
//		task.getUser().setId(id);
		task.setUser(user);
		taskDao.save(task);
		ModelAndView mav = new ModelAndView("redirect:/tasks/" );//+ task.getId());
//		mav.addObject("title", "Edit Task");
		return mav;	
	}
	
	@RequestMapping("/tasks/add")
	public ModelAndView addTasks(@SessionAttribute(name="user", required=false)User user) {
		ModelAndView mav = new ModelAndView("taskform");
//		mav.addObject("user", user.getId());
		mav.addObject("title", "Add Task");
		return mav;	
	}
	
	@RequestMapping(value="/tasks/add", method=RequestMethod.POST)
	public ModelAndView submitAddTasks(Task task, @SessionAttribute(name="user", required=false)User user) {
		task.setUser(user);
		taskDao.save(task);
		return new ModelAndView("redirect:/tasks");
//		return mav;	
	}
	
	@RequestMapping("/tasks/{id}/delete")
	public ModelAndView deleteTasks(@PathVariable("id") Long id) {
		taskDao.deleteById(id);
		ModelAndView mav = new ModelAndView("redirect:/tasks");
		return mav;	
	}
	

	
	


}
