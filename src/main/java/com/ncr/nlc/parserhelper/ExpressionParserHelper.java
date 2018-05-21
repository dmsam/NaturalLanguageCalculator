package com.ncr.nlc.parserhelper;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.ncr.nlc.enumtypes.OperandEnum;
import com.ncr.nlc.enumtypes.OperatorEnum;

/**
 * Class that parses input expression
 * 
 * @author doma.samson
 *
 */
public class ExpressionParserHelper {
	private ExpressionParserHelper() {

	}

	/**
	 * This method translates expression to numeric representation
	 * 
	 * @param inputString
	 * @return Optional<String>
	 */
	public static Optional<String> generateNumericExpression(List<String> inputString) {
		StringBuilder generatedString = new StringBuilder();
		if (inputString != null) {
			inputString.stream().forEach(token -> {
				if (OperandEnum.isOperand(token)) {
					generatedString.append(OperandEnum.getNumberValue(token));
					generatedString.append(" ");
				} else if (OperatorEnum.isOperator(token)) {
					generatedString.append(OperatorEnum.getOperatorValue(token));
					generatedString.append(" ");
				} else {
					throw new IllegalArgumentException("Token not found");
				}
			});
		}
		return Optional.of(generatedString.toString());
	}

	/**
	 * Parses the expression and translates the expression to a postfix stack for
	 * later evaluation using Shunting yard algorithm
	 * 
	 * @param infixExpressionOpt
	 * @return Optional<String>
	 */
	public static Optional<String> infixToReversePolishNotation(Optional<String> infixExpressionOpt) {
		StringBuilder output = new StringBuilder();
		Deque<String> rpnQueue;
		if (infixExpressionOpt.isPresent()) {
			String infixExpression = infixExpressionOpt.get();
			rpnQueue = new LinkedList<>();
			for (String token : infixExpression.split("\\s")) {
				if (isOperatorToken(token)) {
					while (!rpnQueue.isEmpty() && isHigerPrec(token, rpnQueue.peek()))
						output.append(rpnQueue.pop()).append(' ');
					rpnQueue.push(token);
				} else {
					output.append(token).append(' ');
				}
			}
			while (!rpnQueue.isEmpty())
				output.append(rpnQueue.pop()).append(' ');
		}
		return Optional.of(output.toString());
	}

	/**
	 * This method compares operators based on their precedence
	 * 
	 * @param op
	 * @param sub
	 * @return boolean
	 */
	private static boolean isHigerPrec(String op, String sub) {
		return (isOperatorToken(sub) && OperatorEnum.getPrecedenceValue(sub) >= OperatorEnum.getPrecedenceValue(op));

	}

	/**
	 * Method that checks whether operator is of specific type
	 * 
	 * @param token
	 * @return boolean
	 */
	public static boolean isOperatorToken(String token) {
		return token.equals("/") || token.equals("*") || token.equals("+") || token.equals("-");
	}
}
