package com.hamboomger.crossweb.dao;

import com.hamboomger.crossweb.model.CrosswebEvent;
import com.hamboomger.model.common.Language;
import com.hamboomger.model.event.EventAddress;
import com.hamboomger.model.event.EventAgenda;
import com.hamboomger.model.event.EventType;
import com.hamboomger.model.event.PriceType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author ddorochov
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CrosswebEventsDaoTest {

	@Autowired
	private CrosswebEventsDao dao;

	@Test
	public void testDao() {
		CrosswebEvent event = createEvent();
		dao.deleteAll();
		dao.saveAndFlush(event);

		CrosswebEvent eventFromDao = dao.findByName(event.getTitle());
		assertThat(eventFromDao, notNullValue());
		assertThat(eventFromDao.getPageUrl(), equalTo(event.getPageUrl()));
	}

	private CrosswebEvent createEvent() {
		EventAgenda eventAgenda = new EventAgenda(
				Arrays.asList("Some appointment", "Another appointment"),
				"Some info\nAnother info"
		);

		List<String> topics = Arrays.asList("First topic", "Second topic");

		return new CrosswebEvent.Builder()
			.setName("Great event")
			.setDescription("Event description")
			.setAddress(new EventAddress("Warsaw", "Warsaw Spire", "al. Jerozolimskie"))
			.setAgenda(eventAgenda)
			.setDateAndTime(LocalDateTime.now())
			.setPageUrl("http://mockurl.com")
			.setLanguage(Language.ENGLISH)
			.setPriceType(PriceType.FREE)
			.setTopics(topics)
			.setType(EventType.MEETUP)
			.build();
	}

}