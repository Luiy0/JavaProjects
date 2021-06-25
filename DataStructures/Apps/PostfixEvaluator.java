/*
 * PostfixEvaluator.java
 * This class represents an evaluator of postfix expressions. It
 * assumes the operands are numeric literals.
 */

package Apps;

import Structures.Stack;
import Structures.ArrayStack;

import java.util.Scanner;

public class PostfixEvaluator {
	
	// Field for the stack where operands are placed
	private Stack<Double> operands = new ArrayStack<>();
		
	// Evaluates the specified postfix expression.
	public double evaluate(String expr) {
		double result = 0.0;
		
		// separa los operandos
		Scanner tokenizer = new Scanner(expr);
		
		while (tokenizer.hasNext()) {
			String token = tokenizer.next();
			
			if (isOperator(token)) {  //(+, -, /, *)
				double operand2 = operands.pop();
				double operand1 = operands.pop();
				result = evaluateOperator(token.charAt(0), operand1, operand2);
				operands.push(result);
			}
			else
				operands.push(Double.parseDouble(token));
		}
		tokenizer.close();
		return result;
	}

	// Determines if the specified token is an operator.
	private boolean isOperator(String token) {
		return (token.equals("+") || token.equals("-") || 
				token.equals("*") || token.equals("/"));
	}
	
	// Evaluates a single subexpression consisting of the given operator 
	// and its operands.
	private double evaluateOperator(char operator, 
			double operand1, double operand2) {
		
		switch (operator) {
			case '+':
				return operand1 + operand2;
			case '-':
				return operand1 - operand2;
			case '*':
				return operand1 * operand2;
			case '/':
				return operand1 / operand2;
			default:
				return 0.0;
		}
	}

}

