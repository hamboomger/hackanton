package com.hackanton.crossweb;

import com.hackanton.crossweb.scrapping.CrosswebScannerService;
import com.hackanton.event.Event;
import com.hackanton.event.EventsSearchConfiguration;
import com.hackanton.event.filter.EventFilterService;
import com.hackanton.event.filter.IEventsFilter;
import com.hackanton.user.User;
import com.hackanton.user.UserService;
import com.hackanton.user.email.EmailService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CrosswebScanJob {

    private final UserService userService;
    private final CrosswebScannerService crosswebScannerService;
    private final EventFilterService eventFilterService;
	private final EmailService emailService;

	public CrosswebScanJob(UserService userService, CrosswebScannerService crosswebScannerService, EventFilterService eventFilterService, EmailService emailService) {
		this.userService = userService;
		this.crosswebScannerService = crosswebScannerService;
		this.eventFilterService = eventFilterService;
		this.emailService = emailService;
	}

//	@Scheduled
	public void scan() throws IOException {
		List<Event> events = crosswebScannerService.scanNewEvents();
		List<User> users = userService.getAllUsers();

		for (User user : users) {
			EventsSearchConfiguration searchConfig = user.getSearchConfiguration();
			IEventsFilter filter = eventFilterService.createFilter(searchConfig);
			List<Event> filteredEvents = events.stream()
					.filter(filter::apply)
					.collect(Collectors.toList());

			emailService.sendNewEvents(user, filteredEvents);
		}
	}

}
