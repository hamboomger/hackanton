package com.hackanton.crossweb.model;

import com.hackanton.crossweb.parsing.CrosswebEventNameAndLink;
import com.hackanton.crossweb.parsing.CrosswebMainPageParser;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author ddorochov
 */
public class CrosswebMainPageParserTest {
    private static final String PAGE_URL = "http://crossweb.pl/en/events/java/";

    @Test
    public void testParsing() throws IOException {
        // arrange
        CrosswebMainPageParser parser = new CrosswebMainPageParser();

        // act
        List<CrosswebEventNameAndLink> events = parser.getEventsShortInfo(PAGE_URL);

        // assert
        assertNotNull(events);
		assertTrue(!events.isEmpty());
		events.forEach(event -> System.out.println(String.format(
				"Event name: %s\nEvent link:%s \n", event.getName(), event.getUrl()
		)));
    }

}