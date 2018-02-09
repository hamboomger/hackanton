package com.hamboomger.crossweb.model;

import com.hamboomger.model.common.Language;
import com.hamboomger.model.event.EventType;
import com.hamboomger.model.event.IEvent;
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

    private static final String PAGE_URL = "https://crossweb.pl/en/events/biometric-authentication-luty-2018/";

    @Test
    public void testEventParsing() throws IOException {
        // arrange
        CrosswebEventPageParser parser = new CrosswebEventPageParser();

        // act
        IEvent event = parser.parse(PAGE_URL);

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

        assertEquals(event.getTitle(), "Biometric Authentication");
        assertEquals(event.getType(), EventType.MEETUP);
        assertEquals(event.getTopics(), Arrays.asList("IT", "security"));
        assertEquals(event.getDateAndTime(), LocalDateTime.of(2018, 2, 8, 18, 0));
        assertEquals(event.getPageUrl(), "https://crossweb.pl/en/events/biometric-authentication-luty-2018/");
        assertEquals(event.getAddress().getCity(), "Warszawa");
        assertEquals(event.getAddress().getPlace(), "InnVento");
        assertEquals(event.getAddress().getFullAddress(), "Kasprzaka 25");
        assertEquals(event.getLanguage(), Language.ENGLISH);
    }

}
