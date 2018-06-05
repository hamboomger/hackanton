package com.hamboomger.crossweb.model;

import java.util.List;

/**
 * Created by Medai on 06.12.2017.
 */
public class CrossWebEventArticleTest {
    String nameOfEvent;
    String eventType;
    List<String> topic;
    String date; // type date?
    String time;
    String language;
    String price; // type int?
    String city;
    String place;
    String address;
    String linkOnEvent;
    String speakers;
    String description;
    String linkOnFacebook;
    String linkOnRegistration;

    public CrossWebEventArticleTest(String nameOfEvent, String eventType, List<String> topic, String date, String time, String language, String price, String city, String place, String address, String linkOnEvent, String speakers, String description, String linkOnFacebook, String linkOnRegistration) {
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
        this.speakers = speakers;
        this.description = description;
        this.linkOnFacebook = linkOnFacebook;
        this.linkOnRegistration = linkOnRegistration;
    }

    @Override
    public String toString() {
        return "CrossWebEventArticleTest{" +
                "nameOfEvent='" + nameOfEvent +'\n'+ '\'' +
                ", eventType='" + eventType +'\n'+ '\'' +
                ", topic=" + topic +'\n'+
                ", date='" + date +'\n'+ '\'' +
                ", time='" + time +'\n'+ '\'' +
                ", language='" + language +'\n'+ '\'' +
                ", price='" + price +'\n'+ '\'' +
                ", city='" + city +'\n'+ '\'' +
                ", place='" + place +'\n'+ '\'' +
                ", address='" + address +'\n'+ '\'' +
                ", linkOnEvent='" + linkOnEvent +'\n'+ '\'' +
                ", speakers='" + speakers +'\n'+ '\'' +
                ", description='" + description +'\n'+ '\'' +
                ", linkOnFacebook='" + linkOnFacebook +'\n'+ '\'' +
                ", linkOnRegistration='" + linkOnRegistration +'\n'+ '\'' +
                '}';
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public String getLinkOnFacebook() {
        return linkOnFacebook;
    }

    public void setLinkOnFacebook(String linkOnFacebook) {
        this.linkOnFacebook = linkOnFacebook;
    }

    public String getLinkOnRegistration() {
        return linkOnRegistration;
    }

    public void setLinkOnRegistration(String linkOnRegistration) {
        this.linkOnRegistration = linkOnRegistration;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<String> getTopic() {
        return topic;
    }

    public void setTopic(List<String> topic) {
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
        return speakers;
    }

    public void setSpeaker(String speaker) {
        this.speakers = speaker;
    }


}
