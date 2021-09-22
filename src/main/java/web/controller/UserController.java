package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.RoleDao;
import web.model.User;
import web.service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {
	private  UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String helloPage() {
		return "index";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {
		List<String> messages = new ArrayList<>();
		model.addAttribute("user", userService.findByUserName(principal.getName()));
		return "user/hello";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}


	@GetMapping(value = "/admin")
	public String printAllUsers(Model model) {
		model.addAttribute("userList", userService.listUser());
		return "users";
	}

	@GetMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") Long id) {
		userService.removeUser(id);
		return "redirect:/admin";
	}

	@GetMapping(value = "new")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

	@PostMapping
	public String addNewUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/admin";
	}

	@GetMapping(value = "/{id}")
	public String showUser(@PathVariable("id") Long id, Model model) {
		model.addAttribute(userService.getUser(id));
		return "userinfo";
	}

	@GetMapping(value = "/{id}/edit")
	public  String editUser(Model model, @PathVariable("id") Long id) {
		model.addAttribute("user", userService.getUser(id) );
		return "edit";
	}

	@PostMapping("/{id}")
	public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
		userService.updateUser(user);
		return "redirect:/admin";
	}



}