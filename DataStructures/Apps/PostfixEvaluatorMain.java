/*
 * PostfixEvaluatorMain.java
 * This application demonstrates the use of a stack to evaluate 
 * postfix expressions.
 */

package Apps;

import java.util.Scanner;

public class PostfixEvaluatorMain {

	// Serves as the entry point for this application.
	public static void main(String[] args) {

		String again;
		Scanner keyboard = new Scanner(System.in);
				
		do {
			PostfixEvaluator evaluator = new PostfixEvaluator();
			
			System.out.print("Enter a valid postfix expression: ");
			String expression = keyboard.nextLine();
			System.out.println();
			
			double result = evaluator.evaluate(expression);
			System.out.println("The expression equals " + result);
			System.out.println();
			
			System.out.print("Evaluate another expression (Y/N)? ");
			again = keyboard.nextLine();
			System.out.println();
		} while (again.equalsIgnoreCase("y"));
		keyboard.close();
		System.out.println("Thanks for using this program.");
	}

}

