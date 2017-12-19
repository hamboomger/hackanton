package com.hamboomger.crossweb.model;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author ddorochov
 */
public class CrosswebMainPageParserTest {
    public static final String PAGE_URL = "http://crossweb.pl/en/events/java/";

    @Test
    public void testParsing() throws IOException {
        // arrange
        CrosswebMainPageParser parser = new CrosswebMainPageParser();

        // act
        List<CrosswebEventNameAndLink> events = parser.getEventsShortInfo(PAGE_URL);

        // assert
        assertTrue(events != null);
		assertTrue(!events.isEmpty());
		events.forEach(event -> System.out.println(String.format(
				"Event name: %s\nEvent link:%s \n", event.getName(), event.getUrl()
		)));
    }

}