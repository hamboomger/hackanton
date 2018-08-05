package com.hackanton.event.filter;

import com.hackanton.event.EventType;
import com.hackanton.event.EventsSearchConfiguration;
import com.hackanton.event.IEvent;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author ddorochov
 */
public class EventTypeFilterFactoryTest {

	private EventTypeFilterFactory factory = new EventTypeFilterFactory();
	private EventsSearchConfiguration searchConfig;

	@Before
	public void initSearchConfig() {
		this.searchConfig = mock(EventsSearchConfiguration.class);
		when(searchConfig.getEventTypes()).thenReturn(Arrays.asList(EventType.HACKATHON, EventType.MEETUP));
	}

	@Test
	public void checkWhenTypeExists() {
		// arrange
		IEvent event = mock(IEvent.class);
		when(event.getType()).thenReturn(EventType.HACKATHON);

		// act
		IEventsFilter filter = factory.createFilter(searchConfig);
		boolean result = filter.apply(event);

		// assert
		assertTrue(result);
	}

}