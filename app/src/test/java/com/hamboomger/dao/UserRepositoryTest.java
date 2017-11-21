package com.hamboomger.dao;

import com.hamboomger.SpringTestConfiguration;
import com.hamboomger.model.common.Role;
import com.hamboomger.model.common.User;
import com.hamboomger.model.event.EventType;
import com.hamboomger.model.event.PriceType;
import com.hamboomger.model.search.EventsSearchConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ddorochov
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Import(SpringTestConfiguration.class)
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void testConfiguration() {
		// arrange
		String email = "valid@mail.com";
		String username = "Huston";
		String password = "12345";
		List<Role> roles = Collections.singletonList(new Role("USER"));
		EventsSearchConfiguration config = new EventsSearchConfiguration(
				Arrays.asList("kotlin", "java"), Arrays.asList(EventType.MEETUP, EventType.HACKATHON), PriceType.FREE
		);
		User user = new User(email, password, username, true, roles, config);

		// act
		repository.saveAndFlush(user);
		User fetchedUser = repository.findByUsername(username);

		// assert
		assertNotNull(fetchedUser);
		assertEquals(email, fetchedUser.getEmail());
		assertTrue(fetchedUser.getSearchConfiguration().getKeywords().size() == 2);
	}

}