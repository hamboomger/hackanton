package com.hamboomger.crossweb.model;

import com.hamboomger.model.event.IEvent;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by Medai on 06.12.2017.
 */
public class CrosswebEventPageParserTest {

    public static final String PAGE_URL = "https://crossweb.pl/en/events/open-coffee-ktw-vol-12/";

    @Test
    public void testEventParsing() throws IOException {
        // arrange
        CrosswebEventPageParser parser = new CrosswebEventPageParser();

        // act
        IEvent event = parser.parse(PAGE_URL);
        String description = event.getDescription();
        String title = event.getName();
        LocalDateTime dateAndTime = event.getDateAndTime();

        // assert
        Assert.assertTrue();

        Elements eventDetail = doc.getElementsByClass("event-detail");
        for (Element event : eventDetail) {
            String nameOfevent = getElementAfter("Event:", event);
            String eventType = getElementAfter("Event type:", event);
            String date = getElementAfter("Date:", event);
            String time = getElementAfter("Time:", event);
            String language = getElementAfter("Language:", event);
            String price = getElementAfter("Price:", event);
            String city = getElementAfter("City:", event);
            String place = getElementAfter("Place:", event);
            String address = getElementAfter("Address:", event);
            String linkOfEvent = getElementAfter("www:", event);
            for(String topikTosplit : getElementAfter("Topic:", event).split(", ")){
                topik.add(topikTosplit);
            }
            String speakers = event.getElementsByClass("speker-name").text();
            String description = event.getElementsByClass("event-detail description").text();// переделать так как бывает забирает вместе с собой агенду!
            // через див не получается забрать потому что бывает много параграфов (крч нужно думать !)))
            String linkOnFacebook = getElementAfter("Registration:", event);
            String linkOnRegistration = getElementAfter("Facebook:", event);
            //need to add agenda and do smth with itaration (too many loops)
            eventAricle.add(new CrossWebEventArticleTest(nameOfevent, eventType, topik, date, time, language, price, city, place, address, linkOfEvent, speakers,description,linkOnFacebook,linkOnRegistration));
        }
        System.out.println(eventAricle);
    }
    
    public String getElementAfter(String name, Element element) {
        String query = "div:containsOwn("+name+")";
        return element.select(query).next().text();
    }
    
}
