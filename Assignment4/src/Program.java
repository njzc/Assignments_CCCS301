/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 4 
	5.Where you developed your program: Eclipse
*/

import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input the number of airplanes: ");
		int numOfAirplanes = scanner.nextInt();
		scanner.close();
		
		Airport airport = new Airport(numOfAirplanes);
		airport.menu();
		
	}

}
