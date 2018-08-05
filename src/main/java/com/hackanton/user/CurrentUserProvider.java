package com.hackanton.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author ddorochov
 */
@Component
public class CurrentUserProvider implements ICurrentUserProvider {

	private final UserService userService;

	@Autowired
	public CurrentUserProvider(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth == null) return null;

		String userName = auth.getName();
		return userService.findByName(userName);
	}
}
