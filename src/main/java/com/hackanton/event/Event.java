package com.hackanton.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ddorochov
 */
public interface Event {

	@NotNull
	String getTitle();

	@NotNull
	EventType getType();

	@NotNull
	List<String> getTopics();

	@NotNull
	PriceType getPriceType();

	/**
	 * @return date and time of this event
	 */
	@NotNull
	LocalDateTime getDateAndTime();

	/**
	 * @return page from which this event was parsed
	 */
	@NotNull
	String getPageUrl();

	@NotNull
	EventAddress getAddress();

	@Nullable
	EventAgenda getAgenda();

	@NotNull
	String getDescription();

	@NotNull
	Language getLanguage();
}
