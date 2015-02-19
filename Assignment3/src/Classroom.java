/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 3 
	5.Where you developed your program: Eclipse
*/

public class Classroom {

	private Student students[];

	public Classroom(int maxClassroomSize)
	{
		students = new Student[maxClassroomSize];
	}
	
	public boolean add(Student aStudent)
	{
		if ( aStudent != null )
		{
			for (int i = 0; i < students.length; i++)
			{
				if ( students[i] == null)
				{
					students[i] = aStudent;
					return true;
				}
			}
		}
		
		return false;
	}
	
	public Student getStudent(int position)
	{
		if ( position >= 0 && position < students.length)
		{
			return students[position];
		}
		
		return null;
	}
}
