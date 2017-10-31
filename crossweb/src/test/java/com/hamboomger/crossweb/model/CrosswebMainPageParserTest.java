package com.hamboomger.crossweb.model;

import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ddorochov
 */
public class CrosswebMainPageParserTest {

	@Test
	private void testParsing() {
		// arrange
		CrosswebMainPageParser parser = new CrosswebMainPageParser();
		InputStream is = getClass().getResourceAsStream("crossweb_main_page.html");

		// act
		List<CrosswebEventNameAndLink> events = parser.getEvents(is);

		// assert
		assertTrue(events != null);
		assertTrue(!events.isEmpty());
	}

}