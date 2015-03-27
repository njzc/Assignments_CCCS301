/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 4 
	5.Where you developed your program: Eclipse
*/

import java.util.Scanner;

public class Recursion {


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input a single sentence: ");
		String inputString = scanner.nextLine();
		System.out.println("The reverse of this sentence is: ");
		System.out.println(ReversePrint(inputString));
		
		scanner.close();
	}

	public static String ReversePrint(String msg)
	{
		if ( msg.length() == 0 )
		{
			return "";
		}
		else
		{
			return msg.charAt(msg.length() - 1) + ReversePrint(msg.substring(0, msg.length() - 1));
		}
	}
}
