package com.hackanton.event.filter;

import com.hackanton.common.BaseWordsSearchStrategy;
import com.hackanton.event.EventsSearchConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ddorochov
 */
@Component
public class KeywordsFilterFactory implements ISinglePropertyFilterFactory {
	@Override
	public IEventsFilter createFilter(EventsSearchConfiguration configuration) {
		List<String> keywords = configuration.getKeywords();
		if(keywords.isEmpty())
			return null;
		else
			return new KeywordsEventsFilter(keywords, new BaseWordsSearchStrategy());
	}
}
