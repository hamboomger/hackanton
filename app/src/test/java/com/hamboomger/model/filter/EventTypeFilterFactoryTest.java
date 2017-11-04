package com.hamboomger.model.filter;

import com.hamboomger.model.event.EventType;
import com.hamboomger.model.event.IEvent;
import com.hamboomger.model.search.EventsSearchConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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