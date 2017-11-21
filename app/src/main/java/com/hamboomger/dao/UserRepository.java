package com.hamboomger.dao;

import com.hamboomger.model.common.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ddorochov
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByUsername(String username);
}
