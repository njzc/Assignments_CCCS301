
public class Recursion {


	public static void main(String[] args) {

		System.out.println(ReversePrint("This is mary"));
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
