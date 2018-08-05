package com.hackanton.crossweb.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ddorochov
 */
@Repository
public interface CrosswebEventsDao extends JpaRepository<CrosswebEvent, Long> {
	CrosswebEvent findByName(String name);
}
