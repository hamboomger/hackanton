package com.hamboomger.web.controller;

import com.hamboomger.model.common.User;
import com.hamboomger.model.search.EventsSearchConfiguration;
import com.hamboomger.web.auth.IAuthenticationProvider;
import com.hamboomger.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author ddorochov
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

	private final UserService userService;
	private final IAuthenticationProvider authProvider;

	@Autowired
	public UserRestController(UserService userService, IAuthenticationProvider authProvider) {
		this.userService = userService;
		this.authProvider = authProvider;
	}

	@GetMapping
	public User getUser() {
		Authentication auth = authProvider.getAuthentication();
		return userService.findByName(auth.getName());
	}

	@GetMapping("/config")
	public EventsSearchConfiguration getConfiguration() {
		Authentication auth = authProvider.getAuthentication();
		User user = userService.findByName(auth.getName());
		return user.getSearchConfiguration();
	}
	
	@DeleteMapping("/config/keywords/{keywordName}")
	@Transactional
	public void deleteKeyword(@PathVariable String keywordName) {
		Authentication auth = authProvider.getAuthentication();
		User user = userService.findByName(auth.getName());
		EventsSearchConfiguration searchConfig = user.getSearchConfiguration();
		
		searchConfig.deleteKeyword(keywordName);
	}

	@PutMapping("/config/keywords/{keywordName}")
	@Transactional
	public void createKeyword(@PathVariable String keywordName) {
		Authentication auth = authProvider.getAuthentication();
		User user = userService.findByName(auth.getName());
		EventsSearchConfiguration searchConfig = user.getSearchConfiguration();

		searchConfig.addKeyword(keywordName);
	}

}
