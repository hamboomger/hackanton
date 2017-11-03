package com.hamboomger.model.filter;

import com.hamboomger.model.event.IEvent;
import com.hamboomger.model.event.PriceType;
import com.hamboomger.model.search.EventsSearchConfiguration;
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

		public EventPriceTypeFilter(PriceType priceType) {
			this.priceType = priceType;
		}

		@Override
		public boolean apply(IEvent event) {
			return event.getPriceType() == priceType;
		}
	}

}
