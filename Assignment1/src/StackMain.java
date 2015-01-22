/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 1 
	5.Where you developed your program: Eclipse
*/

import java.text.DecimalFormat;
import java.util.Scanner;

public class StackMain {

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int validCount = 0;
		TheStack aStack = new TheStack();
		
		// read 10 valid numbers into stack
		while ( validCount < 10 )
		{
			System.out.print("Please enter No." + ( validCount + 1) + " number, which should be a non-negative integer: ");
			int number = input.nextInt();
			
			boolean pushResult = aStack.push(number);
			if ( pushResult == true )
			{
				validCount++;
				System.out.println("Push " + number + " successfully.");
			}
			else
			{
				System.out.println("Fail to push number: " + number);
			}
		}
		input.close();

		// pop all input numbers one by one
		System.out.println();
		System.out.println("The numbers in the stack are (in reverse order): ");
		int popValue = aStack.pop();
		while (popValue != -9999)
		{	
			System.out.print(popValue + " ");
			popValue = aStack.pop();
		}
	}

}
