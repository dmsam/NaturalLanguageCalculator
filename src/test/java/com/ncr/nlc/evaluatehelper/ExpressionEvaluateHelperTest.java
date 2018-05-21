package com.ncr.nlc.evaluatehelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Tests for ExpressionEvaluteHelper class
 * @author doma.samson
 *
 */
class ExpressionEvaluateHelperTest {

	private Optional<String> parsedInputOpt;
	
	@Test
	void reversePolishNotationShouldReturnExpectedStringOutput() {
		parsedInputOpt = Optional.of("1 2 3 * + ");
		Double actual = ExpressionEvaluateHelper.reversePolishNotationToResult(parsedInputOpt);
		Double expected = 7.0;
		assertEquals(actual,expected);
	}
	@Test
	@DisplayName("throws NoSuchElementException when null input is passed")
	void reversePolishNotationShouldThrowExceptionIfInputIsNull() {
		parsedInputOpt = Optional.ofNullable(null); 
		assertThrows(NoSuchElementException.class,() ->  ExpressionEvaluateHelper.reversePolishNotationToResult(parsedInputOpt));
	}
}
