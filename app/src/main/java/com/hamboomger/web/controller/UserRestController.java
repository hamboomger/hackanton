package com.hamboomger.web.controller;

import com.hamboomger.model.common.User;
import com.hamboomger.model.search.EventsSearchConfiguration;
import com.hamboomger.web.auth.ICurrentUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author ddorochov
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

	private final ICurrentUserProvider userProvider;

	@Autowired
	public UserRestController(ICurrentUserProvider userProvider) {
		this.userProvider = userProvider;
	}

	@GetMapping
	public User getUser() {
		return userProvider.getCurrentUser();
	}

	@GetMapping("/config")
	public EventsSearchConfiguration getConfiguration() {
		User user = userProvider.getCurrentUser();
		return user.getSearchConfiguration();
	}
	
	@DeleteMapping("/config/keywords/{keywordName}")
	@Transactional
	public void deleteKeyword(@PathVariable String keywordName) {
		User user = userProvider.getCurrentUser();
		EventsSearchConfiguration searchConfig = user.getSearchConfiguration();
		
		searchConfig.deleteKeyword(keywordName);
	}

	@PutMapping("/config/keywords/{keywordName}")
	@Transactional
	public void createKeyword(@PathVariable String keywordName) {
		User user = userProvider.getCurrentUser();
		EventsSearchConfiguration searchConfig = user.getSearchConfiguration();

		searchConfig.addKeyword(keywordName);
	}

}
