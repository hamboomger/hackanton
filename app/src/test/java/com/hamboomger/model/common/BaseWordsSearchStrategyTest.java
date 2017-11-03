package com.hamboomger.model.common;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author ddorochov
 */
public class BaseWordsSearchStrategyTest {

	private String text = "In the Middle of the night";
	private BaseWordsSearchStrategy searchStrategy = new BaseWordsSearchStrategy();

	@Test
	public void checkWhenHalfOfWordPassedThenReturnFalse() {
		//act
		boolean result = searchStrategy.textContains(text, "mid");
		//assert
		assertFalse(result);
	}

	@Test
	public void checkWhenTextHasNewLine() {
		//act
		boolean result = searchStrategy.textContains(text + "\n", "Middle");
		//assert
		assertTrue(result);
	}

	@Test	// text contains new line and multiple words are passed into it.
	public void checkComplex1() {
		//act
		boolean result = searchStrategy.textContains("\n" + text +"\n", "middle of the night");
		//assert
		assertTrue(result);
	}

	@Test
	public void checkWhenOneWordShouldBeFound() {
		//act
		boolean result = searchStrategy.textContains(text, "Middle");
		//assert
		assertTrue(result);
	}

	@Test
	public void checkWhenMultipleWordsShouldBeFound() {
		//act
		boolean result = searchStrategy.textContains(text, "In the");
		//assert
		assertTrue(result);
	}

	@Test
	public void checkWhenWholeTextShouldBeFound() {
		//act
		boolean result = searchStrategy.textContains(text, text);
		//assert
		assertTrue(result);
	}

}