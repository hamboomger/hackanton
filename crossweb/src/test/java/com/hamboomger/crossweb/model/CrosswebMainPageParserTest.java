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
 * @author ddorochov
 */
public class CrosswebMainPageParserTest {
    List<CrossWebMainArticleTest> articleList = new ArrayList<>();

    @Test
    public void testParsing() throws IOException {
        // arrange
        CrosswebMainPageParser parser = new CrosswebMainPageParser();
        //InputStream is = getClass().getResourceAsStream("/crossweb_main_page.html");
        Document doc = Jsoup.connect("http://crossweb.pl/en/events/java/").get();

        Elements brows = doc.getElementsByClass("brow");
        for (Element brow : brows) {
            String url = "https://crossweb.pl/" + brow.attr("href");
            String title = brow.getElementsByClass("colTab title").text();
            articleList.add(new CrossWebMainArticleTest(url, title));
        }

        articleList.forEach(System.out::println);

        //System.out.println("------------\n"+articleList.get(0)); // для себя проверял )
        //assertTrue(is != null);
        //assertTrue(is.available() > 0);

        // act
        //List<CrosswebEventNameAndLink> events = parser.getEvents(is);

        // assert
        //assertTrue(events != null);
//		assertTrue(!events.isEmpty());
    }

}