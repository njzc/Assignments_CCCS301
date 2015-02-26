
public interface Transactions {
	public void deposit (double amount); 
	public void	withdrawal (double amount); 
	public double getBalance(); 

	public static final double overdraftFee = 5.00;
}
