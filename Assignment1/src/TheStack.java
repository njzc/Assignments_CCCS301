/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 1 
	5.Where you developed your program: Eclipse
*/

public class TheStack {

	private int array[];
	private int top;
	
	private final int DEFAULT_VALUE = -1;
	
	public TheStack()
	{
		array = new int[20];
		for(int i = 0; i < array.length; i++)
		{
			array[i] = DEFAULT_VALUE;
		}
		
		top = 0;
	}
	
	public boolean push(int value)
	{
		if (!isFull())
		{
			if ( value >= 0 )
			{
				array[top] = value;
				top++;
				return true;
			}
		}

		return false;
	}
	
	public int pop()
	{
		if (isEmpty())
		{
			return -9999;
		}
		else
		{
			top--;
			int value = array[top];
			array[top] = DEFAULT_VALUE;
			return value;
		}
	}
	
	public boolean isEmpty()
	{
		for(int i = 0; i < array.length; i++)
		{
			if ( array[i] != DEFAULT_VALUE)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isFull()
	{
		return top == array.length;
	}
}
