package com.hamboomger.crossweb.model;

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
		Elements brows = doc.getElementsByClass("brow");
		if(brows == null)
			return new ArrayList<>();

		return brows.stream()
				.map(assembleFunction)
				.collect(Collectors.toList());
	}

	private Function<Element, CrosswebEventNameAndLink> assembleFunction = (brow) -> {
		String pageUrl = "https://crossweb.pl" + brow.attr("href");
		String title = brow.getElementsByClass("colTab title").text();
		return new CrosswebEventNameAndLink(title, pageUrl);
	};

}
