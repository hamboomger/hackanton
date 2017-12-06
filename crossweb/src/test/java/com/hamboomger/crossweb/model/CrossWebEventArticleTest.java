package com.hamboomger.crossweb.model;

/**
 * Created by Medai on 06.12.2017.
 */
public class CrossWebEventArticleTest {
    String nameOfEvent;
    String eventType;
    String topic;
    String date; // type date?
    String time;
    String language;
    String price; // type int?
    String city;
    String place;
    String address;
    String linkOnEvent;
    String speaker;

    @Override
    public String toString() {
        return "CrossWebEventArticleTest{"+"\n" +
                "nameOfEvent='" + nameOfEvent + '\''+"\n" +
                ", eventType='" + eventType + '\''+"\n" +
                ", topic='" + topic + '\''+"\n" +
                ", date='" + date + '\''+"\n" +
                ", time='" + time + '\''+"\n" +
                ", language='" + language + '\''+"\n" +
                ", price='" + price + '\''+"\n" +
                ", city='" + city + '\''+"\n" +
                ", place='" + place + '\''+"\n" +
                ", address='" + address + '\''+"\n" +
                ", linkOnEvent='" + linkOnEvent + '\''+"\n" +
                ", speaker='" + speaker + '\''+"\n" +
                '}';
    }

    public CrossWebEventArticleTest(String nameOfEvent, String eventType, String topic, String date, String time, String language, String price, String city, String place, String address, String linkOnEvent, String speaker) {
        this.nameOfEvent = nameOfEvent;
        this.eventType = eventType;
        this.topic = topic;
        this.date = date;
        this.time = time;
        this.language = language;
        this.price = price;
        this.city = city;
        this.place = place;
        this.address = address;
        this.linkOnEvent = linkOnEvent;
        this.speaker = speaker;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkOnEvent() {
        return linkOnEvent;
    }

    public void setLinkOnEvent(String linkOnEvent) {
        this.linkOnEvent = linkOnEvent;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }


}
