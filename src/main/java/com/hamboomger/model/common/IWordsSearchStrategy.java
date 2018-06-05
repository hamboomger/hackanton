package com.hamboomger.model.common;

/**
 * @author ddorochov
 */
public interface IWordsSearchStrategy {
	boolean textContains(String text, String keyword);
}
