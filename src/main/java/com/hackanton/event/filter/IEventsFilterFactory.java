package com.hackanton.event.filter;

import com.hackanton.event.EventsSearchConfiguration;

/**
 * @author ddorochov
 */
public interface IEventsFilterFactory {
	IEventsFilter createFilter(EventsSearchConfiguration configuration);
}
