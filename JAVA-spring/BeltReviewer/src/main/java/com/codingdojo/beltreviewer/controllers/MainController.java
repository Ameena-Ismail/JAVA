package com.codingdojo.beltreviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.beltreviewer.models.Event;
import com.codingdojo.beltreviewer.models.User;
import com.codingdojo.beltreviewer.services.UserService;
import com.codingdojo.beltreviewer.validator.UserValidator;

@Controller
public class MainController {
    private final UserService userService;
    private final UserValidator userValidator;
    
    public MainController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/")
    public String index(@ModelAttribute("user") User user) {
    	return "index.jsp";
    }
//    @RequestMapping("/registration")
//    public String registerForm(@ModelAttribute("user") User user) {
//        return "registrationPage.jsp";
//    }
//    @RequestMapping("/login")
//    public String login() {
//        return "loginPage.jsp";
//    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	userValidator.validate(user, result);
    	if(result.hasErrors()) {
    		return "index.jsp";
    	}
    	User u = userService.registerUser(user);
    	session.setAttribute("userId", u.getId());
    	return "redirect:/home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User u = userService.findByEmail(email);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	}else {
    		model.addAttribute("user", new User());
    		model.addAttribute("error", "Invalid Credentials. Please try again.");
    		return "index.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model,@ModelAttribute("event") Event myEvent) {
        // get user from session, save them in the model and return the home page
    	Long userId = (Long) session.getAttribute("userId");
    	User u = userService.findUserById(userId);
    	model.addAttribute("user",u);
    	return "homePage.jsp";
    	}
    
    
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

    @RequestMapping(value="/create/event", method=RequestMethod.POST)
    public String createEvent(@ModelAttribute("event")Event myEvent) {
    	
    	
    	return "homePage.jsp";
    }
    
}
