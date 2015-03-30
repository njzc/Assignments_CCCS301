/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 3 
	5.Where you developed your program: Eclipse
*/

class FullContainer extends ContainerVer1 implements CompareObjects
{
	private int size; 
	
	FullContainer(int size) 
	{
		super(size);
		this.size = size;
	}
	
	// make sure every object added into the container implements CompareObjects
	public boolean add(CompareObjects item)
	{
		return super.add(item);
	}

	public void duplicate(int index)
	{
		super.add(((CompareObjects)super.get(index)).clone());
	}
	
	public Object clone()
	{
		FullContainer container = new FullContainer(size);
		for (int i = 0; i < size; i++)
		{
			super.add(super.get(i));
		}
		return container;
	}
	
	public boolean equals(Object o)
	{
		FullContainer anotherContainer = (FullContainer)o;

		if (o != null) 
		{
			for (int i = 0; i < size; i++) 
			{
				if (!super.get(i).equals(anotherContainer.get(i))) {
					return false;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
		
	}
}