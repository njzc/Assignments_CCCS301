import java.util.Scanner;


public class Tester2 {

	public static void main(String[] args) {
		
		final int SIZE = 2;
		
		FullContainer container = new FullContainer(SIZE);

		Scanner input = new Scanner(System.in);
		
		int menuItem = 0;
		do 
		{
			System.out.println("(1) Create account, (2) Delete account, (3) Deposit, (4) Withdraw, (5) Get balance, (6) Duplicate account, (7) Quit");
			System.out.println("Please input a number (between 1 to 7): ");
			menuItem = input.nextInt();
			
			input.nextLine(); // consume the "\n" after nextInt or nextDouble
			
			switch(menuItem)
			{
				// Create account
				case 1:
					System.out.println("Please input the account number: ");
					String accountNumber = input.nextLine();
					System.out.println("Please input the initial balance: ");
					double balance = input.nextDouble();
					
					BankAccount account = new BankAccount(accountNumber, balance);
					if ( container.add(account) == true )
					{
						System.out.println("Create account successfully");
					}
					else
					{
						System.out.println("Create account unsuccessfully, the container is full.");
					}
					System.out.println();
					break;
					
				// Delete account
				case 2:
					System.out.println("Please input a number which indicates the account you want to delete: ");
					int deleteNumber = input.nextInt();
					if ( container.delete(deleteNumber))
					{
						System.out.println("Delete account successfully");
					}
					else
					{
						System.out.println("Delete account unsuccessfully, the number you input is wrong.");
					}
					System.out.println();
					break;
				
				default:
					break;
			}
			
		}while ( menuItem != 7 );
		
		
		input.close();
		
	}

}
