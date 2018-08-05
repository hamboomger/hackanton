package com.hackanton.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author ddorochov
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByUsername(String username);
}
