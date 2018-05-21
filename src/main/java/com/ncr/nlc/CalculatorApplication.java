package com.ncr.nlc;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ncr.nlc.consolewriter.ConsoleWriter;
import com.ncr.nlc.controller.NaturalLanguageCalculationController;

/**
 * This is the main class to invoke program to perform natural language
 * calculations
 * 
 * @author doma.samson
 *
 */
public class CalculatorApplication {
	private static final Logger logger = Logger.getLogger(CalculatorApplication.class.getName());

	public static void main(String[] args) {
		logger.log(Level.INFO, "Entered main method");
		NaturalLanguageCalculationController controller = NaturalLanguageCalculationController.getInstance();
		try (Scanner scanner = new Scanner(System.in);) {
			ConsoleWriter.printToConsole("Please enter a calculation: ");
			String input;
			while (scanner.hasNext()) {
				input = scanner.nextLine();
				double result = controller.processInput(input);
				ConsoleWriter.printToConsole(String.format("Result : %.3g", result));
				ConsoleWriter.printToConsole("Please enter a calculation: ");
			}
		} catch (IllegalArgumentException illegalArgumentException) {
			logger.log(Level.SEVERE, "Error in reading input", illegalArgumentException);
		}
		logger.log(Level.INFO, "Exiting main method");
	}
}
