package com.hamboomger.crossweb.model;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ddorochov
 */
public class CrosswebMainPageParserTest {

	@Test
	public void testParsing() throws IOException {
		// arrange
		CrosswebMainPageParser parser = new CrosswebMainPageParser();
		InputStream is = getClass().getResourceAsStream("/crossweb_main_page.html");

		assertTrue(is != null);
		assertTrue(is.available() > 0);

		// act
		List<CrosswebEventNameAndLink> events = parser.getEvents(is);

		// assert
		assertTrue(events != null);
//		assertTrue(!events.isEmpty());
	}

}