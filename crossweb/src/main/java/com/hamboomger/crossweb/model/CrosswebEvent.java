package com.hamboomger.crossweb.model;

import com.hamboomger.model.common.Language;
import com.hamboomger.model.event.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static com.hamboomger.util.EntityBuildingToolkit.*;

/**
 * @author ddorochov
 */
@Entity
@Access(AccessType.FIELD)
public class CrosswebEvent implements IEvent {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private EventType type;

	@ElementCollection
	private List<String> topics;

	@Column
	private PriceType priceType;

	@Column
	private LocalDateTime dateAndTime;

	@Column
	private String pageUrl;

	@Embedded
	private EventAddress address;

	@Embedded
	private EventAgenda agenda;

	@Column
	private String description;

	@Column
	private Language language;

	private CrosswebEvent(Builder builder) {
		this.name = builder.name;
		this.type = builder.type;
		this.topics = builder.topics;
		this.priceType = builder.priceType;
		this.dateAndTime = builder.dateAndTime;
		this.pageUrl = builder.pageUrl;
		this.address = builder.address;
		this.agenda = builder.agenda;
		this.description = builder.description;
		this.language = builder.language;
	}

	protected CrosswebEvent() {}

	@NotNull
	@Override
	public String getName() {
		return name;
	}

	@NotNull
	@Override
	public EventType getType() {
		return type;
	}

	@NotNull
	@Override
	public List<String> getTopics() {
		return topics;
	}

	@NotNull
	@Override
	public PriceType getPriceType() {
		return priceType;
	}

	@NotNull
	@Override
	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	@NotNull
	@Override
	public String getPageUrl() {
		return pageUrl;
	}

	@NotNull
	@Override
	public EventAddress getAddress() {
		return address;
	}

	@Nullable
	@Override
	public EventAgenda getAgenda() {
		return agenda;
	}

	@NotNull
	@Override
	public String getDescription() {
		return description;
	}

	@NotNull
 	@Override
	public Language getLanguage() {
		return language;
	}

	public static class Builder {
		private String name;
		private EventType type;
		private List<String> topics;
		private PriceType priceType;
		private LocalDateTime dateAndTime;
		private String pageUrl;
		private EventAddress address;
		private EventAgenda agenda;
		private String description;
		private Language language;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setType(EventType type) {
			this.type = type;
			return this;
		}

		public Builder setTopics(List<String> topics) {
			this.topics = topics;
			return this;
		}

		public Builder setPriceType(PriceType priceType) {
			this.priceType = priceType;
			return this;
		}

		public Builder setDateAndTime(LocalDateTime dateAndTime) {
			this.dateAndTime = dateAndTime;
			return this;
		}

		public Builder setPageUrl(String pageUrl) {
			this.pageUrl = pageUrl;
			return this;
		}

		public Builder setAddress(EventAddress address) {
			this.address = address;
			return this;
		}

		public Builder setAgenda(EventAgenda agenda) {
			this.agenda = agenda;
			return this;
		}

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setLanguage(Language language) {
			this.language = language;
			return this;
		}

		public CrosswebEvent build() {
			verifyParameters();
			return new CrosswebEvent(this);
		}

		private void verifyParameters() {
			checkNullOrEmpty(name, "name");
			checkNull(type, "type");
			checkNullOrEmpty(topics, "topics");
			checkNull(priceType, "priceType");
			checkNull(pageUrl, "pageUrl");
			checkNull(address, "address");
			checkNullOrEmpty(description, "description");
			checkNull(language, "language");
		}

	}

}
