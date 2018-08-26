package com.hackanton.crossweb.model;

import com.hackanton.crossweb.parsing.CrosswebEventPageParser;
import com.hackanton.event.Event;
import com.hackanton.event.EventType;
import com.hackanton.event.Language;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Medai on 06.12.2017.
 */
public class CrosswebEventPageParserTest {

    private static final String PAGE_URL = "https://crossweb.pl/en/events/healthcare-day-czerwiec-2018/";

    @Test
    public void testEventParsing() throws IOException {
        // arrange
        CrosswebEventPageParser parser = new CrosswebEventPageParser();

        // act
        Event event = parser.parse(PAGE_URL);

        // assert
        assertNotNull(event);
        assertNotNull(event.getTitle());
        assertNotNull(event.getType());
        assertNotNull(event.getTopics());
        assertNotNull(event.getPriceType());
        assertNotNull(event.getDateAndTime());
        assertNotNull(event.getPageUrl());
        assertNotNull(event.getAddress());
        assertNotNull(event.getAgenda());
        assertNotNull(event.getDescription());
        assertNotNull(event.getLanguage());

        assertEquals(event.getTitle(), "Healthcare Day");
        assertEquals(event.getType(), EventType.MEETUP);
        assertEquals(event.getTopics(), Arrays.asList("IT", "startup", "Cloud"));
        assertEquals(event.getDateAndTime(), LocalDateTime.of(2018, 6, 5, 9, 30));
        assertEquals(event.getPageUrl(), PAGE_URL);
        assertEquals(event.getAddress().getCity(), "Warszawa");
        assertEquals(event.getAddress().getPlace(), "Startberry");
        assertEquals(event.getAddress().getFullAddress(), "Grochowska 306/308");
        assertEquals(event.getLanguage(), Language.POLISH);

        System.out.println(event.getDescription());
    }

}
