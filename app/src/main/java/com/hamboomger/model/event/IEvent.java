package com.hamboomger.model.event;

import com.hamboomger.model.common.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ddorochov
 */
public interface IEvent {

	@NotNull
	String getTitle();

	@NotNull
	EventType getType();

	@NotNull
	List<String> getTopics();

	@NotNull
	PriceType getPriceType();

	@NotNull
	LocalDateTime getDateAndTime();

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
