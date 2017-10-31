package com.hamboomger.crossweb.dao;

import com.hamboomger.crossweb.model.CrosswebEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ddorochov
 */
@Repository
public interface CrosswebEventsDao extends JpaRepository<CrosswebEvent, Long> {
	CrosswebEvent findByName(String name);
}
