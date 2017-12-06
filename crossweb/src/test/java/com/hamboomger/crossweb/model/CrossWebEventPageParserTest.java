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

    @Test
    public void testEventParsing() throws IOException{

       Document doc = Jsoup.connect("https://crossweb.pl//en/events/jsession-6/").get();

        Elements eventDetail = doc.getElementsByClass("event-detail");
        for(Element event : eventDetail){
            String nameOfevent = event.select("div:containsOwn(Event:)").next().text();
            String eventType = event.select("div:containsOwn(Event type:)").next().text();
            String topic = event.select("div:containsOwn(Topic:)").next().text(); // split(,) and put in list
            String date = event.select("div:containsOwn(Date:)").next().text();
            String time = event.select("div:containsOwn(Time:)").next().text();
            String language = event.select("div:containsOwn(Language:)").next().text();
            String price = event.select("div:containsOwn(Price:)").next().text();
            String city = event.select("div:containsOwn(City:)").next().text();
            String place = event.select("div:containsOwn(Place:)").next().text();
            String address = event.select("div:containsOwn(Address:)").next().text();
            String linkOfEvent = event.select("div:containsOwn(www:)").next().text();
            //need to add description and agenda
            //String speaker = event.select("div:containsOwn(Speakers:)").next().text();
            eventAricle.add(new CrossWebEventArticleTest(nameOfevent,eventType,topic,date,time,language,price,city,place,address,linkOfEvent,null));
        }
        System.out.println(eventAricle);
    }
}
