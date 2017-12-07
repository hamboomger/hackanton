package com.hamboomger.web.controller;

import com.hamboomger.model.event.IEvent;
import com.hamboomger.web.auth.ICurrentUserProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ddorochov
 */
@RestController
@RequestMapping("/events")
public class SearchRestController {

	private final ICurrentUserProvider userProvider;

	@Autowired
	public SearchRestController(ICurrentUserProvider userProvider) {
		this.userProvider = userProvider;
	}

	@GetMapping("/search")
	public List<IEvent> searchForEvents() {
		return null; // TODO implement
	}

}
