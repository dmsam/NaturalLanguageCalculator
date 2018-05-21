package com.ncr.nlc.evaluatehelper;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;
import com.ncr.nlc.parserhelper.ExpressionParserHelper;

/**
 * Class that evaluates the mathematical expression
 * 
 * @author doma.samson
 *
 */
public class ExpressionEvaluateHelper {
	/**
	 * Private constructor added to make helper class non instantiable
	 */
	private ExpressionEvaluateHelper() {
	}

	/**
	 * This method evaluates the expression in reverse polish notation to result
	 * 
	 * @param parsedInputOpt
	 * @return double
	 */
	public static double reversePolishNotationToResult(Optional<String> parsedInputOpt) {
		Deque<String> resultQueue = new LinkedList<>();
		double rightOperand;
		double leftOperand;
		double result = 0;
		Map<String, DoubleBinaryOperator> operatorMap = createOperatorMap();
		if (parsedInputOpt.isPresent()) {
			String parsedInput = parsedInputOpt.get();
			for (String token : parsedInput.split("\\s")) {
				if (ExpressionParserHelper.isOperatorToken(token)) {
					rightOperand = Double.parseDouble(resultQueue.pop());
					leftOperand = Double.parseDouble(resultQueue.pop());
					result = operatorMap.get(token).applyAsDouble(leftOperand, rightOperand);
					resultQueue.push(String.valueOf(result));
				} else {
					resultQueue.push(token);
				}

			}
		}
		return Double.parseDouble(resultQueue.pop());

	}

	/**
	 * This method creates operator map which stores values using
	 * DoubleBinaryOperator
	 * 
	 * @return
	 */
	private static Map<String, DoubleBinaryOperator> createOperatorMap() {
		Map<String, DoubleBinaryOperator> map = new HashMap<>();
		map.put("+", (firstInput, secondInput) -> firstInput + secondInput);
		map.put("-", (firstInput, secondInput) -> firstInput - secondInput);
		map.put("*", (firstInput, secondInput) -> firstInput * secondInput);
		map.put("/", (firstInput, secondInput) -> firstInput / secondInput);
		return map;
	}
}
