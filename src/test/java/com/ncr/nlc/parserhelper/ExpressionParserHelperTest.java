package com.ncr.nlc.parserhelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Tests for ExpressionParserHelper class
 * @author doma.samson
 *
 */
class ExpressionParserHelperTest {
	private List<String> inputString;
	private Optional<String> infixExpression;
	
	@Test
	void reversePolishNotationToResultShouldReturnExpectedDoubleOutput() {
		inputString = Arrays.asList(("one plus two times three").split("\\s+"));
		Optional<String> actual = ExpressionParserHelper.generateNumericExpression(inputString);
		Optional<String> expected = Optional.of("1 + 2 * 3 ");
		assertEquals(actual,expected);
	}
	@Test
	@DisplayName("throws IllegalArgumentException When illegal argument is passed")
	void processInputThrowsException() {
		inputString = Arrays.asList(("one pls two").split("\\s+"));
		 Throwable t = assertThrows(IllegalArgumentException.class, () -> ExpressionParserHelper.generateNumericExpression(inputString));
		 assertEquals("Token not found", t.getMessage());
	}
	@Test
	void infixToReversePolishNotationShouldReturnExpectedStringOutput() {
		infixExpression = Optional.of("1 + 2 * 3 "); 
		Optional<String> actual = ExpressionParserHelper.infixToReversePolishNotation(infixExpression);
		Optional<String>  expected = Optional.of("1 2 3 * + ");
		assertEquals(actual,expected);
	}
	@Test
	void infixToReversePolishNotationShouldReturnEmptyIfInputIsNull() {
		infixExpression = Optional.ofNullable(null); 
		Optional<String> actual = ExpressionParserHelper.infixToReversePolishNotation(infixExpression);
		Optional<String> expected = Optional.of("");
		assertEquals(actual,expected);
	}
}
