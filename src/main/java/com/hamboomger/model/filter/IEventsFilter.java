package com.hamboomger.model.filter;

import com.hamboomger.model.event.IEvent;

/**
 * @author ddorochov
 */
public interface IEventsFilter {
	boolean apply(IEvent event);
}
