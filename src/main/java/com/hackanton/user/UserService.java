package com.hackanton.user;

import com.hackanton.event.EventsSearchConfiguration;
import com.hackanton.event.PriceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ddorochov
 */
@Service
@Transactional
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByName(String username) {
		return userRepository.findByUsername(username);
	}

	@Transactional
	public void registerUser(User user) {
		if(userRepository.exists(user.getId()))
			throw new IllegalArgumentException("User with name " + user.getUsername() + " already exists");

		if(findByEmail(user.getEmail()) != null)
			throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");

		if(findByName(user.getUsername()) != null)
			throw new IllegalArgumentException("User with name " + user.getUsername() + " already exists");

		Role role = roleRepository.findByName("USER");
		user.setRoles(Arrays.asList(role));
		createDefaultConfiguration(user);

		userRepository.save(user);
	}

	private void createDefaultConfiguration(User user) {
		EventsSearchConfiguration configuration = new EventsSearchConfiguration(
				new ArrayList<>(), new ArrayList<>(), PriceType.FREE
		);
		user.setSearchConfiguration(configuration);
	}

}
