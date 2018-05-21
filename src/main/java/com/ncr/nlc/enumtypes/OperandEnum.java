package com.ncr.nlc.enumtypes;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enum to define operands
 * 
 * @author doma.samson
 *
 */
public enum OperandEnum {
	ZERO_VAL(0, "zero"), ONE_VAL(1, "one"), TWO_VAL(2, "two"), THREE_VAL(3, "three"), FOUR_VAL(4, "four"), FIVE_VAL(5,
			"five"), SIX_VAL(6,
					"six"), SEVEN_VAL(7, "seven"), EIGHT_VAL(8, "eight"), NINE_VAL(9, "nine"), TEN_VAL(10, "ten");

	private final int value;
	private final String naturalLangugeNumber;

	private OperandEnum(int value, String naturalLangugeNumber) {
		this.value = value;
		this.naturalLangugeNumber = naturalLangugeNumber;
	}

	public int getNumber() {
		return this.value;
	}

	public static boolean isOperand(String token) {
		return Arrays.stream(OperandEnum.values()).anyMatch(key -> key.naturalLangugeNumber.equalsIgnoreCase(token));
	}

	public static int getNumberValue(String token) {
		Optional<OperandEnum> operandEnumOptional = Arrays.stream(OperandEnum.values())
				.filter(key -> key.naturalLangugeNumber.equalsIgnoreCase(token)).findAny();
		if (operandEnumOptional.isPresent()) {
			return operandEnumOptional.get().value;
		} else {
			throw new IllegalArgumentException("Token not found");
		}
	}
}
