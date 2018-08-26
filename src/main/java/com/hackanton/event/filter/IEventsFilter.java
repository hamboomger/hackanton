package com.hackanton.event.filter;

import com.hackanton.event.Event;

/**
 * @author ddorochov
 */
public interface IEventsFilter {
	boolean apply(Event event);
}
