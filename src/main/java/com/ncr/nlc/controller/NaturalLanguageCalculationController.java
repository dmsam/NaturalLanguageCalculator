package com.ncr.nlc.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.ncr.nlc.evaluatehelper.ExpressionEvaluateHelper;
import com.ncr.nlc.parserhelper.ExpressionParserHelper;

/**
 * Class that implements CalculationController interface
 * 
 * @author doma.samson
 *
 */
public class NaturalLanguageCalculationController implements CalculationController {
	/**
	 * Static factory method to create instance
	 * 
	 * @return
	 */
	public static NaturalLanguageCalculationController getInstance() {
		return new NaturalLanguageCalculationController();
	}

	/**
	 * Private constructor to block instance creation from outside
	 */
	private NaturalLanguageCalculationController() {

	}

	/**
	 * Implementation of processInput method which handles the input
	 */
	public double processInput(String input) {
		double result = 0;
		List<String> splitString;
		Optional<String> generatedString;
		Optional<String> parsedInput;
		if (input != null) {
			splitString = Arrays.asList(input.split("\\s+"));
			generatedString = ExpressionParserHelper.generateNumericExpression(splitString);
			parsedInput = ExpressionParserHelper.infixToReversePolishNotation(generatedString);
			result = ExpressionEvaluateHelper.reversePolishNotationToResult(parsedInput);
		}
		return Math.round(result * 100D) / 100D;
	}

}
