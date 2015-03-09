/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 3 
	5.Where you developed your program: Eclipse
*/

public class BankAccount implements Transactions{

	private String accountNumber;
	private double balance;
	
	public BankAccount(String accountNumber, double balance)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void deposit (double amount)
	{
		if ( amount > 0 )
		{
			balance = balance + amount;
		}
	}
	
	public void	withdrawal (double amount)
	{
		if ( amount > 0 )
		{
			balance = balance - amount;
			if ( amount > balance )
			{
				balance = balance - overdraftFee;
			}
		}
	}
	
	public double getBalance()
	{
		return balance;
	}
	
}
