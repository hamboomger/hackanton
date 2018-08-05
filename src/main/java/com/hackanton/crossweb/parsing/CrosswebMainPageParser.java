package com.hackanton.crossweb.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ddorochov
 */
public class CrosswebMainPageParser {
	public List<CrosswebEventNameAndLink> getEventsShortInfo(String url) throws IOException {
		Document doc = Jsoup.connect(url).get();
		Elements rows = doc.getElementsByClass("tab-row");
		if(rows == null)
			return new ArrayList<>();

		return rows.stream()
				.map(assembleFunction)
				.collect(Collectors.toList());
	}

	private Function<Element, CrosswebEventNameAndLink> assembleFunction = (row) -> {
		String pageUrl = "https://crossweb.pl" + row.attr("href");
		String title = row.getElementsByClass("colTab title").text();
		return new CrosswebEventNameAndLink(title, pageUrl);
	};

}
