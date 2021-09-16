package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printAllUsers(Model model) {
		model.addAttribute("userList", userService.listUser());
		return "index";
	}

	@GetMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		userService.removeUser(id);
		return "redirect:/";
	}

	@GetMapping(value = "/new")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}

	@PostMapping
	public String addNewUser(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/";
	}

	@GetMapping(value = "/{id}")
	public String showUser(@PathVariable("id") int id, Model model) {
		model.addAttribute(userService.getUser(id));
		return "user";
	}

	@GetMapping(value = "/{id}/edit")
	public  String editUser(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getUser(id) );
		return "edit";
	}

	@PostMapping("/{id}")
	public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
		userService.updateUser(user);
		return "redirect:/";
	}



}