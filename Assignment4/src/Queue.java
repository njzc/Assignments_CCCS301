/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 4 
	5.Where you developed your program: Eclipse
*/

public class Queue<E> {

	private Object array[];
	
	public Queue()
	{
		array = new Object[10];
	}
	
	public boolean enqueue(E anObject)
	{
		if ( anObject != null )
		{
			if ( isFull())
			{
				doubleSize();
			}

			for (int i = 0; i < array.length; i++)
			{
				if ( array[i] == null )
				{
					array[i] = anObject;
					break;
				}
			}
			
			return true;
		}
		return false;
	}
	
	public boolean insert(E anObject, int aCellPosition)
	{
		if ( aCellPosition >= array.length || aCellPosition < 0 )
		{
			return enqueue(anObject);
		}
		else
		{
			// copy shifted cells to a temp array
			Object temp[] = new Object[array.length - aCellPosition];
			for (int i = 0; i < array.length - aCellPosition; i++)
			{
				temp[i] = array[aCellPosition + i];
				array[aCellPosition + i] = null;
			}
			
			array[aCellPosition] = anObject;
			
			// enqueue from the temp array;
			boolean result = true;			
			for (int i = 0; i < temp.length; i++)
			{
				result = result & enqueue((E)temp[i]);
			}
			return result;
		}
		
	}

	public E dequeue()
	{
		return delete(0);
	}
	
	public E delete(int aCellPosition)
	{
		if ( aCellPosition >= array.length || aCellPosition < 0 )
		{
			return null;
		}
		else
		{
			E obj = (E)array[aCellPosition];
			if ( obj != null )
			{
				//shift cells
				for (int i = aCellPosition; i < array.length - 1; i++)
				{
					array[i] = array[i + 1];
				}
				
				// set last object to null
				array[array.length - 1] = null;
			}
			return obj;
		}
	}
	
	private void doubleSize()
	{
		Object temp[] = new Object[array.length * 2];
		for (int i = 0; i < array.length; i++)
		{
			temp[i] = array[i];
		}
		array = temp;
		temp = null;
	}
	
	private boolean isFull()
	{
		for (int i = 0; i < array.length; i++)
		{
			if ( array[i] == null )
			{
				return false;
			}
		}
		return true;
	}
	
	//TODO： to be deleted
	public String toString()
	{
		String result = "";
		for (int i = 0; i < array.length; i++)
		{
			if ( array[i] != null )
			{
				result += array[i].toString() + ",";
			}
		}
		return result;
	}
}
