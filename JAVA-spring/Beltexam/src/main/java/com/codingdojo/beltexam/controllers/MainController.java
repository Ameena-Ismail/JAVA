package com.codingdojo.beltexam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.beltexam.models.Task;
import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.services.TaskService;
import com.codingdojo.beltexam.services.UserService;
import com.codingdojo.beltexam.validator.UserValidator;

@Controller
public class MainController {
	private final UserService userService;
	private final UserValidator userValidator;
	private final TaskService taskService;

	public MainController(UserService userService, UserValidator userValidator, TaskService taskService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.taskService = taskService;
	}

	// index page
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
		return "redirect:/tasks";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session, @ModelAttribute("user") User user) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if (isAuthenticated) {
			User u = userService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/tasks";
		} else {
//			model.addAttribute("user", new User());
			model.addAttribute("error", "Invalid Credentials. Please try again.");
			return "index.jsp";
		}
	}

	// display homepage
	@RequestMapping("/tasks")
	public String homepage(HttpSession session, Model model) {

		// if current user is in session then proceed, if not redirect to login page
		if (session.getAttribute("userId") != null) {
			// get user from session, save them in the model and return the home page
			Long userId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(userId);
			// model pass u user to jsp in order to display current user login name
			model.addAttribute("user", u);
			// get all tasks and list them on homepage
			List<Task> tasklist = taskService.getAll();
			model.addAttribute("tasks", tasklist);
			return "homePage.jsp";
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

	// display task creation page "task.jsp"
	@RequestMapping("/tasks/new")
	public String displayTaskCreation(@ModelAttribute("task") Task myTask, Model model, HttpSession session) {
		// if current user is in session then proceed, if not redirect to login page
		if (session.getAttribute("userId") != null) {
			// find a list of all users, it will be used in Dropdown menu
			List<User> allusers = userService.findAll();
			model.addAttribute("users", allusers);

			// get current user login info

			// when get user id from session, don't forget to cast data type to Long
			Long userId = (Long) session.getAttribute("userId");
			User u = userService.findUserById(userId);
			model.addAttribute("currentUser", u);
			return "task.jsp";
		} else {
			System.out.println("You have not logined");
			return "redirect:/";
		}
	}

	// create new task
	@RequestMapping(value = "/tasks/new", method = RequestMethod.POST)
	public String createNewTask(@Valid @ModelAttribute("task") Task myTask, BindingResult result, HttpSession session,
			Model model, RedirectAttributes limitError) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		model.addAttribute("user", u);

		if (result.hasErrors()) {
			System.out.println("I got an error");

			// passing list of users back to dropdown menu when errors validation is
			// activated.
			List<User> allusers = userService.findAll();
			model.addAttribute("users", allusers);
			return "task.jsp";
		} else {
			
			// user cannot be assigned more than 3 tasks
			//--------------  Black Belt requirement ---------------
			// get assignee id
			Long aId = (Long) myTask.getAssignee().getId();
			User myAssignee = userService.findUserById(aId);
			// list how many tasks that this user have been assigned to so far
			// if number of tasks is equal or greater than 3, then STOP there
			List<Task> myList = myAssignee.getAssigned_tasks();
			
			if (myList.size() >= 3) {
				System.out.print("At limit");
				List<User> allusers = userService.findAll();
				model.addAttribute("users", allusers);
				limitError.addFlashAttribute("errors", "User cannot be assigned more than 3 tasks");
				return "redirect:/tasks/new";
				
			// --------------- Black Belt --------------------------	
				
			} else {

				System.out.println("No error when created task");
				Task newTask = taskService.createTask(myTask);
				System.out.println("*** Current Login User *** : " + u.getName());

				// add creator(current login user) to a created task
				newTask.setCreator(u);
				// save() change by calling updateTask()
				taskService.updateTask(newTask);

				return "redirect:/tasks";
			}
		}
	}

	// display an individual task "showtask.jsp"
	@RequestMapping("/tasks/{id}")
	public String displayTask(Model model, HttpSession session, @PathVariable("id") Long taskId) {
		// find a task by id
		Task thisTask = taskService.findTask(taskId);
		model.addAttribute("task", thisTask);

		// find a current login user id
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		model.addAttribute("currentUserId", u.getId());
		return "showtask.jsp";
	}

	// show a task edit page - only creator can see (black belt requirement)
	@RequestMapping("/tasks/{id}/edit")
	public String displayEditPage(Model model, @ModelAttribute("edittask") Task myTask, @PathVariable("id") Long taskId,
			HttpSession session) {

		// ---------------------------------------------------------------------------
		// Black belt requirement
		// To prevent user access edit page directly via typing URL /tasks/{id}/edit
		// Current user must be a creator only in order to access this page
		// --------------------------------------------------------------------------

		// get current login user id from session
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);

		// get a task by id
		Task editingTask = taskService.findTask(taskId);

		System.out.println("---- Task Name ----- :" + editingTask.getTaskName());

		if (u.getId() == editingTask.getCreator().getId()) {

			// List all users
			List<User> allUsers = userService.findAll();

			// Getting a task's creator, model pass info back to JSP
			model.addAttribute("creator", editingTask.getCreator());
			model.addAttribute("edittask", editingTask);
			model.addAttribute("users", allUsers);
			model.addAttribute("id", editingTask.getId());
			return "edittask.jsp";
		} else {
			System.out.println("You are not a creator of this task ... get loss !");
			return "redirect:/tasks";
		}

	}

	// update task
	@RequestMapping(value = "/tasks/{id}/edit", method = RequestMethod.POST)
	public String updateTask(Model model, @Valid @ModelAttribute("edittask") Task myTask, BindingResult result,
			@PathVariable("id") Long taskId) {
		System.out.println("Im in update routing");

		if (result.hasErrors()) {
			List<User> allusers = userService.findAll();
			model.addAttribute("users", allusers);
			return "edittask.jsp";
		} else {
			taskService.createTask(myTask);
			return "redirect:/tasks";
		}
	}

	// delete task
	@RequestMapping("/tasks/{id}/delete")
	public String deleteTask(@PathVariable("id") Long myId) {
		Task deltask = taskService.findTask(myId);
		if (deltask != null) {
			taskService.deleteTask(myId);
			return "redirect:/tasks";
		} else {
			return "redirect:/tasks";
		}
	}

	// -------------------------------------------------------
	// Black belt requirements
	// -------------------------------------------------------

	// list tasks from low to high priority
	@RequestMapping("/lowhigh")
	public String lowHigh(HttpSession session, Model model) {

		// get user from session, save them in the model and return the home page
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);

		// model pass u user to jsp in order to display current user login name
		model.addAttribute("user", u);

		// get all tasks and list them on homepage
		List<Task> tasklist = taskService.lowToHigh();
		model.addAttribute("tasks", tasklist);
		return "homePage.jsp";
	}

	// list tasks from high to low priority
	@RequestMapping("/highlow")
	public String HighLow(HttpSession session, Model model) {

		// get user from session, save them in the model and return the home page
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);

		// model pass u user to jsp in order to display current user login name
		model.addAttribute("user", u);

		// get all tasks and list them on homepage
		List<Task> tasklist = taskService.highToLow();
		model.addAttribute("tasks", tasklist);
		return "homePage.jsp";
	}

}
