package com.hamboomger.dao;

import com.hamboomger.model.search.EventsSearchConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ddorochov
 */
public interface EventsSearchConfigurationsDao extends JpaRepository<EventsSearchConfiguration, String> {}
