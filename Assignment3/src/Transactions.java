/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 3 
	5.Where you developed your program: Eclipse
*/

public interface Transactions {
	public void deposit (double amount); 
	
	// this method name should be a verb not a noun "withdrawal"
	public void	withdraw (double amount); 
	
	public double getBalance(); 

	public static final double overdraftFee = 5.00;
}
