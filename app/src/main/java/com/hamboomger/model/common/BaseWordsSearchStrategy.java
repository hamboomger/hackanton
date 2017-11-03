package com.hamboomger.model.common;

import java.util.regex.Pattern;

/**
 * @author ddorochov
 */
public class BaseWordsSearchStrategy implements IWordsSearchStrategy {
	@Override
	public boolean textContains(String text, String keyword) {
		boolean multipleWords = keyword.contains("\\s");

		String textLowerCased = text.toLowerCase();
		String keywordLowerCased = keyword.toLowerCase();

		if(multipleWords) {
			return textLowerCased.contains(keyword);
		} else {
			Pattern pattern = Pattern.compile(".*\\b" + keywordLowerCased + "\\b.*",
					Pattern.MULTILINE | Pattern.DOTALL);
			return pattern.matcher(textLowerCased).matches();
		}
	}
}
