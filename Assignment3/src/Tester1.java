import java.util.Scanner;


public class Tester1 {

	public static void main(String[] args) {
		
		final int SIZE = 20;
		final String DONE = "DONE";
		
		ContainerVer1 container = new ContainerVer1(SIZE);

		Scanner input = new Scanner(System.in);
		
		// populate the container
		String inputString = "";
		int count = 0;
		while ( !inputString.equals(DONE) && count < SIZE )
		{
			System.out.print("Please input a string (enter " + DONE + " in capital letters will stop): " );
			inputString = input.nextLine();
			
			if ( ! inputString.equals(DONE) )
			{
				if ( container.add(inputString) == true )
				{
					System.out.println("Add successfully");
					count++;
				}
			}
		}
		
		System.out.println();
		
		String testAgain = "";
		do 
		{
				
			// Prompt the user for an integer and display what the get() method returns.
			System.out.print("Please enter an integer to get an item. It should be between 0 and " + ( SIZE - 1 ) + ": ");
			int index = input.nextInt();
			Object obj = container.get(index);
			System.out.println("The get() method returns: " + obj);
			System.out.println();
			
			// Ask the user for another integer and invoke the delete() method.
			System.out.print("Please enter an integer to delete an item . It should be between 0 and " + ( SIZE - 1 ) + ": ");
			index = input.nextInt();
			if ( container.delete(index) )
			{
				System.out.println("Delete successfully");
			}
			else
			{
				System.out.println("Delete unsuccessfully");
			}
			System.out.println();
			
			//  Display all the strings in the container
			System.out.println("The strings in the container are: ");
			for ( int i = 0; i < SIZE; i++ )
			{
				System.out.println("Index " + i + ": " + container.get(i));
			}
			System.out.println();
			
			input.nextLine(); // consume the "\n" after nextInt or nextDouble
			
			// Ask the user for a String and then display what the find() and isMember() methods return.
			System.out.print("Please enter a string: ");
			String searchString = input.nextLine();
			int findResult = container.find(searchString);
			System.out.println("The find() method returns: " + findResult);
			boolean isMemberResult = container.isMember(searchString);
			System.out.println("The isMember() method returns: " + isMemberResult);
			System.out.println();
			
			// Ask the user if he wants to test it again
			System.out.println("Would you like to test the container again? (Yes or No): ");
			testAgain = input.nextLine();
			while (! ( testAgain.equalsIgnoreCase("Yes") || testAgain.equalsIgnoreCase("Yes") || testAgain.equalsIgnoreCase("Y") || testAgain.equalsIgnoreCase("No") || testAgain.equalsIgnoreCase("N")))
			{
				System.out.println("Please input a valid string (Yes or No): ");
				testAgain = input.nextLine();
			}
		}
		while (testAgain.equalsIgnoreCase("YES") || testAgain.equalsIgnoreCase("Y") );
		
		input.close();
		
	}

}
