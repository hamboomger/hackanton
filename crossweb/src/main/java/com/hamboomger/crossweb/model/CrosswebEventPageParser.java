package com.hamboomger.crossweb.model;

import com.hamboomger.model.common.Language;
import com.hamboomger.model.event.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ddorochov
 */
public class CrosswebEventPageParser {

	private String pageUrl;

	public IEvent parse(String pageUrl) throws IOException {
		this.pageUrl = pageUrl;
		Document doc = Jsoup.connect(pageUrl).get();

		Element eventDetail = doc.getElementsByClass("event-detail").get(0);
		CrosswebEventImporter importer = new CrosswebEventImporter(eventDetail);
		return new CrosswebEvent(importer);
	}

	private class CrosswebEventImporter implements CrosswebEvent.Importer {

		private Element event;

		CrosswebEventImporter(Element event) {
			this.event = event;
		}

		@Override
		public String getName() {
			return elementTextAfter("Event:", event);
		}

		@Override
		public EventType getType() {
			String eventTypeStr = elementTextAfter("Event type:", event);
			return EventType.valueOf(eventTypeStr.toUpperCase());
		}

		@Override
		public List<String> getTopics() {
			String[] topics = elementTextAfter("Topic:", event).split(", ");
			return Arrays.asList(topics);
		}

		@Override
		public PriceType getPriceType() {
			String priceType = elementTextAfter("Price:", event);
			return PriceType.valueOf(priceType.toUpperCase());
		}

		private Pattern datePattern = Pattern.compile(".*(\\d{2}\\.\\d{2}\\.\\d{4}).*");
		private Pattern timePattern = Pattern.compile(".*(\\d{2}:\\d{2}).*");

		@Override
		public LocalDateTime getDateAndTime() {
            String date = getSubstring(elementTextAfter("Date:", event), datePattern);
            String time = getSubstring(elementTextAfter("Time:", event), timePattern);
            return LocalDateTime.of(
            		LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy")),
					LocalTime.parse(time));
		}

		@Override
		public String getPageUrl() {
			return pageUrl;
		}

		@Override
		public EventAddress getAddress() {
			String city = elementTextAfter("City:", event);
			String place = elementTextAfter("Place:", event);
			String address = elementTextAfter("Address:", event);
			return new EventAddress(city, place, address);
		}

		@Override
		public EventAgenda getEventAgenda() {
			Element agenda = elementAfter("Agenda:", event);
			if(agenda == null) return null;

			List<String> appointments = agenda.select("ul>li").eachText();
			List<String> additionalInfo = agenda.select("p").eachText();
			return new EventAgenda(appointments, String.join("\n", additionalInfo));
		}

		@Override
		public String getDescription() {
			return elementTextAfter("Description:", event);
		}

		@Override
		public Language getLanguage() {
			String language = elementTextAfter("Language:", event);
			return Language.valueOf(language.toUpperCase());
		}
	}

	private String elementTextAfter(String name, Element element) {
		return elementAfter(name, element).text();
	}

	private Element elementAfter(String name, Element element) {
		String query = "div:containsOwn("+name+")";
		return element.select(query).next().first();
	}

	private String getSubstring(String text, Pattern pattern) {
	    Matcher m = pattern.matcher(text);
	    if(!m.find()) {
			throw new IllegalStateException(text + " is not corresponds to pattern " + pattern);
        }

        return m.group(1);
    }

}
