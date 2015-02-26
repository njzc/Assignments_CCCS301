class ContainerVer1
{
	private Object array[];
	
	ContainerVer1(int size) 
	{
		if ( size > 0 )
		{
			array = new Object[size];
		}
	}
	
	public boolean add(Object item)
	{
		if ( array != null )
		{
			for (int i = 0; i < array.length; i++)
			{
				if ( array[i] == null )
				{
					array[i] = item;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public Object get(int index)
	{
		if (array != null && indexIsValid(index))
		{
			return array[index];
		}
		
		return null;
	}
	
	public boolean delete(int index)
	{
		if (array != null && indexIsValid(index))
		{
			array[index] = null;
			return true;
		}
		
		return false;
		
	}
	
	public int find(Object item) 
	{
		if ( array != null )
		{
			for (int i = 0; i < array.length; i++)
			{
				if ( array[i].equals(item))
				{
					return i;
				}
			}
		}
		
		return -1;
	}
	
	public boolean isMember(Object item) 
	{
		return find(item) >= 0;
	}
	
	private boolean indexIsValid(int index)
	{
		return index >= 0 && index < array.length;
	}
}