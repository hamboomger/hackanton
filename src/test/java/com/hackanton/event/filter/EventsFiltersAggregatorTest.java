package com.hackanton.event.filter;

import com.hackanton.event.Event;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author ddorochov
 */
public class EventsFiltersAggregatorTest {

	@Test
	public void testTrueAndFalseFilters() {
		//arrange
		Event event = mock(Event.class);
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
		Event event = mock(Event.class);
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

	private IEventsFilter getMockFilterReturningTrue(Event event) {
		IEventsFilter filter = mock(IEventsFilter.class);
		when(filter.apply(event)).thenReturn(true);
		return filter;
	}

	private IEventsFilter getMockFilterReturningFalse(Event event) {
		IEventsFilter filter = mock(IEventsFilter.class);
		when(filter.apply(event)).thenReturn(false);
		return filter;
	}

}