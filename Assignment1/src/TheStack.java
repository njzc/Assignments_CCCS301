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
	
	// constructor
	public TheStack()
	{
		// initialize array with default values
		array = new int[20];
		for(int item:array)
		{
			item = DEFAULT_VALUE;
		}
		
		top = 0;
	}
	
	// push non-negative number into stack 
	// return true if push successfully, otherwise return false
	public boolean push(int value)
	{
		if (!isFull())  // the stack still has space
		{
			if ( value >= 0 )  // only push non-negative number
			{
				array[top] = value;
				top++;
				return true;
			}
		}

		return false;
	}
	
	// pop the top number from stack
	// if stack is empty, return -9999
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
	
	// check if the stack is empty
	// return true if it is empty, otherwise return false
	public boolean isEmpty()
	{
		for(int item:array)
		{
			if ( item != DEFAULT_VALUE)
			{
				return false;
			}
		}
		
		return true;
	}
	
	// check if the stack is full
	// return true if it is full, otherwise return false
	public boolean isFull()
	{
		for(int item:array)
		{
			if ( item == DEFAULT_VALUE)
			{
				return false;
			}
		}
		
		return true;
	}
}
