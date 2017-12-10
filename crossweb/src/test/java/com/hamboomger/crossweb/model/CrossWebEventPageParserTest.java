package com.hamboomger.crossweb.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Medai on 06.12.2017.
 */
public class CrossWebEventPageParserTest {
    List<CrossWebEventArticleTest> eventAricle = new ArrayList();
    List<String> topik = new ArrayList();

    @Test
    public void testEventParsing() throws IOException {

        Document doc = Jsoup.connect("https://crossweb.pl/en/events/open-coffee-ktw-vol-12/").get();

        Elements eventDetail = doc.getElementsByClass("event-detail");
        for (Element event : eventDetail) {
            String nameOfevent = event.select("div:containsOwn(Event:)").next().text();
            String eventType = event.select("div:containsOwn(Event type:)").next().text();
            String date = event.select("div:containsOwn(Date:)").next().text();
            String time = event.select("div:containsOwn(Time:)").next().text();
            String language = event.select("div:containsOwn(Language:)").next().text();
            String price = event.select("div:containsOwn(Price:)").next().text();
            String city = event.select("div:containsOwn(City:)").next().text();
            String place = event.select("div:containsOwn(Place:)").next().text();
            String address = event.select("div:containsOwn(Address:)").next().text();
            String linkOfEvent = event.select("div:containsOwn(www:)").next().text();
            for(String topikTosplit : event.select("div:containsOwn(Topic:)").next().text().split(", ")){
                topik.add(topikTosplit);
            }
            String speakers = event.getElementsByClass("speker-name").text();
            String description = event.getElementsByClass("event-detail description").text();// переделать так как бывает забирает вместе с собой агенду!
            // через див не получается забрать потому что бывает много параграфов (крч нужно думать !)))
            String linkOnFacebook = event.select("div:containsOwn(Registration:)").next().text();
            String linkOnRegistration = event.select("div:containsOwn(Facebook:)").next().text();
            //need to add agenda and do smth with itaration (too many loops)
            eventAricle.add(new CrossWebEventArticleTest(nameOfevent, eventType, topik, date, time, language, price, city, place, address, linkOfEvent, speakers,description,linkOnFacebook,linkOnRegistration));
        }
        System.out.println(eventAricle);
    }
}
