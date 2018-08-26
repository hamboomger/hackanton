package com.hackanton.event.filter;

import com.hackanton.event.Event;
import com.hackanton.event.EventsSearchConfiguration;
import com.hackanton.event.PriceType;
import org.springframework.stereotype.Component;

/**
 * @author ddorochov
 */
@Component
public class EventPriceFilterFactory implements ISinglePropertyFilterFactory {

	@Override
	public IEventsFilter createFilter(EventsSearchConfiguration configuration) {
		PriceType priceType = configuration.getPriceType();

		if(priceType == null)
			return null;
		else
			return new EventPriceTypeFilter(priceType);
	}

	public class EventPriceTypeFilter implements IEventsFilter {

		private PriceType priceType;

		EventPriceTypeFilter(PriceType priceType) {
			this.priceType = priceType;
		}

		@Override
		public boolean apply(Event event) {
			return event.getPriceType() == priceType;
		}
	}

}
