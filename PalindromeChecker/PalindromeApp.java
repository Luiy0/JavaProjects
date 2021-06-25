/*
 * PalindromeApp.java 
 * 		By Luis A. Flores Carrubio
 * 				8/22/2015
 */

package app;
import java.util.Scanner;
import structure.ArrayStack;
import structure.Stack;

public class PalindromeApp {	
	public static void main(String[] args) {		
		
		//User's Input
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		int answer=0;
		
		do{
		System.out.println("Enter a word to check if it's a palindrome: ");
		String word = kb.next();		
		
		//Store the user's input into a character array
		char[] charsArr = new char[word.length()];
		word.getChars(0, word.length(), charsArr, 0);		
		
		//Pushing the character array data into an  array stack
		Stack<String> stk = new ArrayStack<>();		
		for(int x=0; x<charsArr.length; x++)
			stk.push(Character.toString(charsArr[x]));	
		
		//Pop elements of the stack while comparing them with the char array
		//Popping elements will give the reversed word's characters
		//Checking for equality
		int count=0;
		for(int x=0; x<charsArr.length; x++)
			if(stk.pop().equals(Character.toString(charsArr[x])))
				count++;		
				
		//Check if the user's input qualifies to be a palindrome
		if(count == charsArr.length){
			System.out.println("The word '" + word + "' is a palindrome.");
			System.out.println("Would you like to check another word? 1=Yes, 0=No");
			answer=kb.nextInt();
		}
		else{
			System.out.println("The word '"+ word + "' is not a palindrome. Thank you!");
			System.out.println("Would you like to check another word? 1=Yes, 0=No");
			answer=kb.nextInt();
		}
			
		}while(answer == 1);
		System.out.println("Thank you!");
	}// main
}// class
