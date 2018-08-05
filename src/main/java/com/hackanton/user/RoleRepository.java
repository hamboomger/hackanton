package com.hackanton.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ddorochov
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByName(String name);
}
