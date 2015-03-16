/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 3 
	5.Where you developed your program: Eclipse
*/

import java.util.Scanner;


public class Tester2 {

	public static void main(String[] args) {
		
		final int SIZE = 10;
		
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
					
					BankAccount newAccount = new BankAccount(accountNumber, balance);
					if ( container.add(newAccount) == true )
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
					int deleteIndex = input.nextInt();
					if ( container.delete(deleteIndex))
					{
						System.out.println("Delete account successfully");
					}
					else
					{
						System.out.println("Delete account unsuccessfully, the number you input is wrong.");
					}
					System.out.println();
					break;
					
				// Deposit
				case 3:
					System.out.println("Please input a number which indicates the account you want to deposit: ");
					int depositIndex = input.nextInt();
					BankAccount depositAccount = (BankAccount)container.get(depositIndex); 
					if ( depositAccount != null )
					{
						System.out.println("Please input the amount you want to deposit:");
						double depositAmount = input.nextDouble();
						if ( depositAmount > 0 )
						{
							depositAccount.deposit(depositAmount);
							System.out.println("Deposit successfully");
						}
						else
						{
							System.out.println("The amount you want to deposit should be greater than 0");
						}
					}
					else
					{
						System.out.println("The account you want to deposit doesn't exist.");
					}
					System.out.println();
					break;
				
				// Withdraw
				case 4:
					System.out.println("Please input a number which indicates the account you want to withdraw: ");
					int withdrawIndex = input.nextInt();
					BankAccount withdrawAccount = (BankAccount)container.get(withdrawIndex); 
					if ( withdrawAccount != null )
					{
						System.out.println("Please input the amount you want to withdraw:");
						double withdrawAmount = input.nextDouble();
						if ( withdrawAmount > 0 )
						{
							withdrawAccount.withdraw(withdrawAmount);
							System.out.println("Withdraw successfully");
						}
						else
						{
							System.out.println("The amount you want to withdraw should be greater than 0.");
						}
					}
					else
					{
						System.out.println("The account you want to withdraw doesn't exist.");
					}
					System.out.println();
					
					break;
					
				// Get balance
				case 5:
					System.out.println("Please input a number which indicates the account you want to get balance: ");
					int getBalanceIndex = input.nextInt();
					BankAccount getBalanceAccount = (BankAccount)container.get(getBalanceIndex); 
					if ( getBalanceAccount != null )
					{
						System.out.println("The balance of account " + getBalanceIndex + " is: " + getBalanceAccount.getBalance());
					}
					else
					{
						System.out.println("The account you want to get balance doesn't exist.");
					}
					System.out.println();
					
					break;
					
				// Duplicate account
				case 6:
					System.out.println("Please input a number which indicates the account you want to duplicate: ");
					int duplicateIndex = input.nextInt();
					BankAccount duplicateAccount = (BankAccount)container.get(duplicateIndex); 
					if ( duplicateAccount != null )
					{
						container.duplicate(duplicateIndex);
						System.out.println("Duplicate account successfully");
					}
					else
					{
						System.out.println("The account you want to duplicate doesn't exist.");
					}
					System.out.println();
					
					break;
					

				// Print out all accounts info
				case 7:
					for (int i = 0; i < SIZE; i++)
					{
						BankAccount account = (BankAccount)container.get(i);
						if ( account != null )
						{
							System.out.println("The balance of account " + i + " is: " + account.getBalance());
						}
					}
					break;
					
				default:
					break;
			}
			
		}while ( menuItem != 7 );
		
		
		input.close();
		
	}

}
