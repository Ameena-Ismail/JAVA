package com.schintatkun.java2.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.schintatkun.java2.models.Idea;
import com.schintatkun.java2.models.User;
import com.schintatkun.java2.services.IdeaService;
import com.schintatkun.java2.services.UserService;
import com.schintatkun.java2.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final IdeaService ideaService;

	public MainController(UserService userService, UserValidator userValidator, IdeaService ideaService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.ideaService = ideaService;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User u = userService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/ideas";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if (isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/ideas";
		} else {
			model.addAttribute("user", new User());
			model.addAttribute("error", "Invalid Credentials. Please try again.");
			return "index.jsp";
		}
	}

	// display homepage
	@RequestMapping("/ideas")
	public String homepage(HttpSession session, Model model) {

		// if current user is in session then proceed, if not redirect to login page
		if (session.getAttribute("userId") != null) {
			// get user from session, save them in the model and return the home page
			Long userId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(userId);

			// model pass u user to jsp in order to display current user login name
			model.addAttribute("user", u);

			List<Idea> ideaList = ideaService.findAllIdea();
			model.addAttribute("ideas", ideaList);
			return "homePage.jsp";

		} else {
			System.out.println("You have not logined");
			return "redirect:/";
		}
	}

	//List idea by low to high likes
		@RequestMapping("/lowhigh")
		public String lowhigh(Model model, HttpSession session) {
			
			// if current user is in session then proceed, if not redirect to login page
			if (session.getAttribute("userId") != null) {
				// get user from session, save them in the model and return the home page
				Long userId = (Long) session.getAttribute("userId");
				User u = userService.findUserById(userId);

				// model pass u user to jsp in order to display current user login name
				model.addAttribute("user", u);

				List<Idea> ideaList = ideaService.findLowHigh();
				model.addAttribute("ideas", ideaList);
				return "homepage.jsp";

			} else {
				System.out.println("You have not logined");
				return "redirect:/";
			}
			
		}
	
	
	
	// logout
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// display create new idea page
	@RequestMapping("/ideas/new")
	public String newideaPage(@ModelAttribute("newidea")Idea myIdea) {
		return "newidea.jsp";
	}

	// create idea	
	@RequestMapping(value="/ideas/createnew", method=RequestMethod.POST)
	public String addIdea(@Valid @ModelAttribute("newidea")Idea myIdea, BindingResult result,HttpSession session) {
	
		if (result.hasErrors()) {
			System.out.println("--- Error when create idea ---");
			return "newidea.jsp";
		} else {
			Long userId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(userId);
			
			Idea newIdea = ideaService.createIdea(myIdea);
			newIdea.setCreator(u);
			ideaService.updateIdea(newIdea);
			return "redirect:/ideas";
		}

	}

	// Like
	@RequestMapping("/like/{id}")
	public String addLike(HttpSession session, @PathVariable("id") Long ideaId) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		Idea myIdea = ideaService.findIdea(ideaId);
		myIdea.getLiked_byusers().add(u);
		ideaService.updateIdea(myIdea);

		return "redirect:/ideas";
	}

	// UnLike
	@RequestMapping("/unlike/{id}")
	public String removeLike(HttpSession session, @PathVariable("id") Long ideaId) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		Idea myIdea = ideaService.findIdea(ideaId);
		myIdea.getLiked_byusers().remove(u);
		ideaService.updateIdea(myIdea);

		return "redirect:/ideas";
	}

	// display idea information
	@RequestMapping("/ideas/{id}")
	public String displayEditIdea(@PathVariable("id") Long ideaId, Model model) {
		Idea myIdea = ideaService.findIdea(ideaId);
		List<User> likeUsers = myIdea.getLiked_byusers();
		model.addAttribute("likeUsers", likeUsers);
		model.addAttribute("idea", myIdea);

		return "showidea.jsp";
	}

	// display edit page
	@RequestMapping("/ideas/{id}/edit")
	public String editIdea(HttpSession session, @ModelAttribute("idea") Idea myIdea, @PathVariable("id") Long myId,
			Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);

		Idea findIdea = ideaService.findIdea(myId);
		if (u.getId() == findIdea.getCreator().getId()) {
			model.addAttribute("idea", findIdea);
			return "editidea.jsp";

		} else {
			return "redirect:/ideas/"+myId;
		}
	}
	//update idea
	@PostMapping("/ideas/edit")
	public String updateIdea(HttpSession session,@Valid @ModelAttribute("idea")Idea myIdea, BindingResult result) {
		
		if (result.hasErrors()) {
			return "editidea.jsp";
		}else {
			
//			List<User>  likeUSers = myIdea.getLiked_byusers();
			
			Long userId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(userId);
			myIdea.setCreator(u);
			ideaService.updateIdea(myIdea);
			return "redirect:/ideas";
		}
	}
	
	
	// Delete an idea
	@RequestMapping("/delete/{id}")
	public String deleteIdea(@PathVariable("id") Long myId, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		Idea myIdea = ideaService.findIdea(myId);
		if (myIdea == null) {
			return "redirect:/ideas";
		}if (u.getId() != myIdea.getCreator().getId()) {
			return "redirect:/ideas";
		}
		else {
			ideaService.deleteIdea(myId);
			return "redirect:/ideas";
		}
		
	}
	
}
