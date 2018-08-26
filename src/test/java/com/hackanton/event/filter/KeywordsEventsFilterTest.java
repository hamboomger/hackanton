package com.hackanton.event.filter;

import com.hackanton.common.BaseWordsSearchStrategy;
import com.hackanton.common.exception.EntityBuildingException;
import com.hackanton.event.Event;
import com.hackanton.event.EventAgenda;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author ddorochov
 */
public class KeywordsEventsFilterTest {

	private Event commonEvent;

	private String[] descriptionKeywords = {"Python", "Javascript", "Angular"};
	private String[] agendaKeywords = {"Kotlin", "Ruby on Rails"};
	private String[] missingKeywords = {"Java", "AngularJS", "Groovy on Rails"};

	@Before
	public void initCommonEvent() throws IOException {
		InputStream is = getClass().getResourceAsStream("/event_description.txt");
		String description = IOUtils.toString(is);
		EventAgenda agenda = initAgenda();

		this.commonEvent = mock(Event.class);
		when(commonEvent.getAgenda()).thenReturn(agenda);
		when(commonEvent.getDescription()).thenReturn(description);
	}

	@Test
	public void checkWhenKeywordIsPartOfBiggerWord() {
		//arrange
		KeywordsEventsFilter filter = new KeywordsEventsFilter(
				Arrays.asList("Java"), new BaseWordsSearchStrategy()
		);
		//act
		boolean result = filter.apply(commonEvent);
		//assert
		assertFalse(result);
	}

	@Test
	public void checkWhenDescriptionContainsWord() {
		//arrange
		KeywordsEventsFilter filter = new KeywordsEventsFilter(
				Arrays.asList(descriptionKeywords), new BaseWordsSearchStrategy()
		);
		//act
		boolean result = filter.apply(commonEvent);
		//assert
		assertTrue(result);
	}

	@Test
	public void checkWhenAgendaContainsWord() {
		//arrange
		KeywordsEventsFilter filter = new KeywordsEventsFilter(
				Arrays.asList(agendaKeywords), new BaseWordsSearchStrategy()
		);
		//act
		boolean result = filter.apply(commonEvent);
		//assert
		assertTrue(result);
	}

	@Test
	public void checkWhenThereIsNoWord() {
		//arrange
		KeywordsEventsFilter filter = new KeywordsEventsFilter(
				Arrays.asList(missingKeywords), new BaseWordsSearchStrategy()
		);
		//act
		boolean result = filter.apply(commonEvent);
		//assert
		assertFalse(result);
	}

	@Test(expected = EntityBuildingException.class)
	public void checkWhenNoWordsPassed() {
		//arrange
		KeywordsEventsFilter filter = new KeywordsEventsFilter(new ArrayList<>(), new BaseWordsSearchStrategy());
		//act
		boolean result = filter.apply(commonEvent);
		//assert
		assertFalse(result);
	}

	private EventAgenda initAgenda() {
		String rubyAppointment = "Ruby on Rails for beginners";
		String anotherAppointment = "Something another";
		String thirdAppointment = "And, of course, Kotlin.";
		return new EventAgenda(Arrays.asList(rubyAppointment, anotherAppointment, thirdAppointment));
	}

}