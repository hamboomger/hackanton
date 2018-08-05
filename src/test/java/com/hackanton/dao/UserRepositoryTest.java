package com.hackanton.dao;

import com.hackanton.SpringTestConfiguration;
import com.hackanton.event.EventType;
import com.hackanton.event.EventsSearchConfiguration;
import com.hackanton.event.PriceType;
import com.hackanton.user.Role;
import com.hackanton.user.User;
import com.hackanton.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		assertEquals(2, fetchedUser.getSearchConfiguration().getKeywords().size());
	}

}