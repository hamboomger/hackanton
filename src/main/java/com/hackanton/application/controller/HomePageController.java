package com.hackanton.application.controller;

import com.hackanton.user.ICurrentUserProvider;
import com.hackanton.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ddorochov
 */
@Controller
@RequestMapping("/home")
public class HomePageController {

	private final ICurrentUserProvider userProvider;

	@ModelAttribute("user")
	public User userAttribute() {
		return userProvider.getCurrentUser();
	}

	@Autowired
	public HomePageController(ICurrentUserProvider userProvider) {
		this.userProvider = userProvider;
	}

	@GetMapping
	public String home() {
		return "home";
	}

	@GetMapping("/search")
	public String search() {
		return "search";
	}

}
