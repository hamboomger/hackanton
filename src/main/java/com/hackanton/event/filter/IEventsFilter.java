package com.hackanton.event.filter;

import com.hackanton.event.IEvent;

/**
 * @author ddorochov
 */
public interface IEventsFilter {
	boolean apply(IEvent event);
}
