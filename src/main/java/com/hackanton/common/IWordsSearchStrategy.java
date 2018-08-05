package com.hackanton.common;

/**
 * @author ddorochov
 */
public interface IWordsSearchStrategy {
	boolean textContains(String text, String keyword);
}
