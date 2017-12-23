package com.hamboomger.crossweb.model;

import com.hamboomger.model.common.Language;
import com.hamboomger.model.event.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author ddorochov
 */
public class CrosswebEventPageParser {

	// TODO implement
	public IEvent parse(String pageUrl) throws IOException {
		Document doc = Jsoup.connect(pageUrl).get();

		Element eventDetail = doc.getElementsByClass("event-detail").get(0);
		CrosswebEventImporter importer = new CrosswebEventImporter(eventDetail);
		return new CrosswebEvent(importer);
	}

	private void additionalFields(Element event) {
		String speakers = event.getElementsByClass("speker-name").text();
		// через див не получается забрать потому что бывает много параграфов (крч нужно думать !)))
		String linkOnFacebook = elementAfter("Registration:", event);
		String linkOnRegistration = elementAfter("Facebook:", event);
		//need to add agenda and do smth with iteration (too many loops)
	}

	private class CrosswebEventImporter implements CrosswebEvent.Importer {

		private Element event;

		public CrosswebEventImporter(Element event) {
			this.event = event;
		}

		@Override
		public String getName() {
			return elementAfter("Event:", event);
		}

		@Override
		public EventType getType() {
			String eventTypeStr = elementAfter("Event type:", event);
			return EventType.valueOf(eventTypeStr.toUpperCase());
		}

		@Override
		public List<String> getTopics() {
			String[] topics = elementAfter("Topic:", event).split(", ");
			return Arrays.asList(topics);
		}

		@Override
		public PriceType getPriceType() {
			String priceType = elementAfter("Price:", event);
			return PriceType.valueOf(priceType.toUpperCase());
		}

		@Override
		public LocalDateTime getDateAndTime() {
			String dateStr = elementAfter("Date:", event);
			return LocalDateTime.parse(dateStr);
		}

		@Override
		public String getPageUrl() {
			return elementAfter("www:", event);
		}

		@Override
		public EventAddress getAddress() {
			String city = elementAfter("City:", event);
			String place = elementAfter("Place:", event);
			String address = elementAfter("Address:", event);
			return new EventAddress(city, place, address);
		}

		@Override
		public EventAgenda getEventAgenda() {
			return null;	// TODO implement
		}

		@Override
		public String getDescription() {
			String description = event.getElementsByClass("event-detail description").text();
			// переделать так как бывает забирает вместе с собой агенду!
			// через див не получается забрать потому что бывает много параграфов (крч нужно думать !)))
			return description;
		}

		@Override
		public Language getLanguage() {
			String language = elementAfter("Language:", event);
			return Language.valueOf(language.toUpperCase());
		}
	}

	public String elementAfter(String name, Element element) {
		String query = "div:containsOwn("+name+")";
		return element.select(query).next().text();
	}

}
