/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 3 
	5.Where you developed your program: Eclipse
*/

class FullContainer extends ContainerVer1
{
	
	FullContainer(int size) 
	{
		super(size);
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
	
	
	public boolean equals(Object o)
	{
		return this.equals(o);
	}
}