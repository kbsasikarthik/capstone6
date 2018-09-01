package co.grandcircus.Capstone6;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.Capstone6.dao.UserDao;
import co.grandcircus.Capstone6.entity.User;

//@SessionAttributes("login")
@Controller
public class AuthorizationController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping("/login")
	public ModelAndView showLoginForm() {
		return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public ModelAndView submitLoginForm(HttpSession session, @RequestParam("email") String email, 
	    		@RequestParam("password") String password, RedirectAttributes redir) {
		User user = userDao.findByEmail(email);
	    if (user == null && !password.equals(user.getPassword())) {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("message", "Incorrect username or password.");
			return mav;	            
	    } 
		session.setAttribute("user", user);
		redir.addFlashAttribute("message", "Logged in.");
		return new ModelAndView("redirect:/tasks");

	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session, RedirectAttributes redir) {
		session.invalidate();
		redir.addFlashAttribute("message",  "Logged Out!"); // will be shown only once in the window
		return new ModelAndView("redirect:/");
	}



	
}
