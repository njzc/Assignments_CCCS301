/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 3 
	5.Where you developed your program: Eclipse
*/

public class Student {

	private String name;
	private double gpa;
	
	public Student(String name, double gpa)
	{
		this.name = name;
		this.gpa = gpa;
	}
	
	public void setName(String name)
	{
		if ( !name.isEmpty())
		{
			this.name = name;
		}
	}
	
	public void setGPA(double GPA)
	{
		if ( GPA >= 0 && GPA <= 4)
		{
			this.gpa = GPA;
		}
	}
	
	
	public String getName()
	{
		return this.name;
	}
	
	public double getGPA()
	{
		return this.gpa;
	}
}
