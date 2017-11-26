package com.hamboomger.web.config;

import com.hamboomger.dao.RoleRepository;
import com.hamboomger.model.common.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ddorochov
 */
@Component
public class ApplicationStartConfig {

	private String[] roles = {"USER", "ADMIN"};
	private final RoleRepository roleRepository;

	@Autowired
	public ApplicationStartConfig(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@PostConstruct
	public void addRolesIfNeeded() {
		for(String roleName : roles) {
			Role role = roleRepository.findByName(roleName);
			if(role == null) {
				roleRepository.save(new Role(roleName));
			}
		}
	}

}
