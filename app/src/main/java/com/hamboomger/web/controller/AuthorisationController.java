package com.hamboomger.web.controller;

import com.hamboomger.model.common.User;
import com.hamboomger.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author ddorochov
 */
@Controller
public class AuthorisationController {

	private final UserService userService;

	@Autowired
	public AuthorisationController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = {"/", "/login"})
	public String login() {
		return "login";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String registerNewUser(@Valid User user, BindingResult result, Model model) {
		checkUsername(user, result);
		checkEmail(user, result);
		if(result.hasErrors()) return "registration";

		userService.registerUser(user);

		model.addAttribute("user", user);
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String home(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		model.addAttribute("user", user);
		return "home";
	}

	private void checkUsername(User user, BindingResult result) {
		if(userService.findByName(user.getUsername()) != null) {
			result.rejectValue("email", "error.name",
					"There is already a user registered with the name provided");
		}
	}

	private void checkEmail(User user, BindingResult result) {
		if(userService.findByEmail(user.getEmail()) != null) {
			result.rejectValue("email", "error.email",
					"There is already a user registered with the email provided");
		}
	}

}
