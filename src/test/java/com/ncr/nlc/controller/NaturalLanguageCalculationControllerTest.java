package com.ncr.nlc.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
/**
 * Tests for NaturalLanguageCalculationController class
 * @author doma.samson
 *
 */
class NaturalLanguageCalculationControllerTest {
	static NaturalLanguageCalculationController controller;
	@BeforeAll
	private static void setUp() {
		controller = NaturalLanguageCalculationController.getInstance();
	}
	@Test
	void processInputShouldReturnResultForValidInput_First() {
		String input = "nine over eight plus four times two divided-by three";
		double actual = controller.processInput(input);
		double expected = 3.79;
		assertEquals(actual,expected);
	}
	@Test
	void processInputShouldReturnResultForValidInput_Second() {
		String input = "one plus two times three";
		double actual = controller.processInput(input);
		double expected = 7;
		assertEquals(actual,expected);
	}
	@Test
	void processInputShouldReturnResultForValidInput_Third() {
		String input = "nine minus three times seven";
		double actual = controller.processInput(input);
		double expected = -12;
		assertEquals(actual,expected);
	}
	@Test
	void processInputShouldReturnResultForValidInput_Fourth() {
		String input = "four minus eight plus six times nine";
		double actual = controller.processInput(input);
		double expected = 50;
		assertEquals(actual,expected);
	}
	@Test
	void processInputShouldAcceptCaseInsensitiveInputs() {
		String input = "four MINUS eight plus SiX times nine";
		double actual = controller.processInput(input);
		double expected = 50;
		assertEquals(actual,expected);
	}
	@Test
	void processInputShouldReturnNoResultWhenInputIsnull() {
		String input = null;
		double actual = controller.processInput(input);
		double expected = 0;
		assertEquals(actual,expected);
	}
	@Test
	@DisplayName("throws IllegalArgumentException When illegal argument is passed")
	void processInputThrowsException() {
		 Throwable t = assertThrows(IllegalArgumentException.class, () -> controller.processInput(""));
		 assertEquals("Token not found", t.getMessage());
	}
}
