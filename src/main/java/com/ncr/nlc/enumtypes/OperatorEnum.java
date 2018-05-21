package com.ncr.nlc.enumtypes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Enum to define operators
 * 
 * @author doma.samson
 *
 */
public enum OperatorEnum {
	ADD(1, "+", "add", "plus"), SUBTRACT(1, "-", "subtarct", "minus", "less"), MULTIPLY(2, "*", "multiplied-by",
			"times"), DIVIDE(2, "/", "divided-by", "over");

	private final int precedence;
	private final String operator;
	private final String[] aliases;
	private static final Map<String, String> operatorTypeMap = new HashMap<>();
	private static final Map<String, Integer> precedenceMap = new HashMap<>();
	static {
		for (OperatorEnum op : OperatorEnum.values()) {
			for (String alias : op.aliases) {
				operatorTypeMap.put(alias, op.getOperator());
			}
			precedenceMap.put(op.getOperator(), op.precedence);
		}
	}

	private OperatorEnum(int p, String operator, String... aliases) {
		this.precedence = p;
		this.operator = operator;
		this.aliases = aliases;
	}

	public String getOperator() {
		return this.operator;
	}

	public static boolean isOperator(String token) {
		Predicate<String> equalityPred = key -> key.equalsIgnoreCase(token);
		return operatorTypeMap.keySet().stream().anyMatch(equalityPred);
	}

	public static String getOperatorValue(String token) {
		return operatorTypeMap.get(token.toLowerCase());
	}

	public static Integer getPrecedenceValue(String token) {
		return precedenceMap.get(token);
	}
}
