package com.hamboomger.model.filter;

import com.hamboomger.model.search.EventsSearchConfiguration;

/**
 * @author ddorochov
 */
public interface IEventsFilterFactory {
	IEventsFilter createFilter(EventsSearchConfiguration configuration);
}
