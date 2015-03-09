/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 3 
	5.Where you developed your program: Eclipse
*/

class FullContainer extends ContainerVer1 implements CompareObjects
{
	//private Object array[];
	
	FullContainer(int size) 
	{
		super(size);
	}

	public void duplicate(int index)
	{
		add(get(index));
	}
	
	public boolean equals(Object o)
	{
		return this.equals(o);
	}
}