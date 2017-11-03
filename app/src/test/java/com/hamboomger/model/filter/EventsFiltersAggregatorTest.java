package com.hamboomger.model.filter;

import com.hamboomger.model.event.IEvent;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * @author ddorochov
 */
public class EventsFiltersAggregatorTest {

	@Test
	public void testTrueAndFalseFilters() {
		//arrange
		IEvent event = mock(IEvent.class);
		IEventsFilter filterReturningTrue = getMockFilterReturningTrue(event);
		IEventsFilter filterReturningFalse = getMockFilterReturningFalse(event);

		//act
		EventsFiltersAggregator filtersAggregator = new EventsFiltersAggregator();
		filtersAggregator.addFilter(filterReturningFalse);
		filtersAggregator.addFilter(filterReturningTrue);
		boolean result = filtersAggregator.apply(event);

		//assert
		assertFalse(result);
	}

	@Test
	public void testTrueAndTrueFilters() {
		//arrange
		//arrange
		IEvent event = mock(IEvent.class);
		IEventsFilter filterReturningTrue = getMockFilterReturningTrue(event);
		IEventsFilter anotherFilterReturningTrue = getMockFilterReturningTrue(event);

		//act
		EventsFiltersAggregator filtersAggregator = new EventsFiltersAggregator();
		filtersAggregator.addFilter(anotherFilterReturningTrue);
		filtersAggregator.addFilter(filterReturningTrue);
		boolean result = filtersAggregator.apply(event);

		//assert
		assertTrue(result);
	}

	private IEventsFilter getMockFilterReturningTrue(IEvent event) {
		IEventsFilter filter = mock(IEventsFilter.class);
		when(filter.apply(event)).thenReturn(true);
		return filter;
	}

	private IEventsFilter getMockFilterReturningFalse(IEvent event) {
		IEventsFilter filter = mock(IEventsFilter.class);
		when(filter.apply(event)).thenReturn(false);
		return filter;
	}

}