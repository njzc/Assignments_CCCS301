/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 3 
	5.Where you developed your program: Eclipse
*/

import java.util.Scanner;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		boolean classroomSizeIsValid = false;
		int classroomSize = 0;
		int numberOfStudents = 0;
		
		do
		{
			System.out.print("Please input the size of a classroom: ");
			classroomSize = input.nextInt();
			
			if ( classroomSize > 0 )
			{
				classroomSizeIsValid = true;
				
				boolean numberOfStudentsIsValid = false;
				
				do 
				{	
					System.out.print("Please input the number of students: ");
					numberOfStudents = input.nextInt();
					
					if ( numberOfStudents > 0 )
					{
						numberOfStudentsIsValid = true;
					}
					else
					{
						System.out.println("The number of students must be greater than zero.");
					}
				}while (numberOfStudentsIsValid == false);
				
			}
			else
			{
				System.out.println("The size of a classroom must be greater than zero.");
			}
			
		}while (classroomSizeIsValid == false);
		
		Classroom classroom = new Classroom(classroomSize);
		
		
		for (int i = 0; i < numberOfStudents; i++)
		{
			input.nextLine(); // consume the "\n" after nextInt or nextDouble
			
			System.out.print("Please input the name of the student: ");
			String name = input.nextLine();
			
			System.out.print("Please input the GPA of the stadent: ");
			double gpa = input.nextDouble();
			
			Student student = new Student(name, gpa);
			if ( classroom.add(student) == true )
			{
				System.out.println("Add student " + name + " successfully.");
			}
			else
			{
				System.out.println("Failed to add student " + name + ", because the classroom is full.");
			}
		}
		
		input.close();
		
		// print out all students info
		System.out.println();
		for (int i = 0; i < classroomSize; i++)
		{
			Student student = classroom.getStudent(i);
			if ( student != null )
			{
				System.out.println("Student name: " + student.getName() + ", GPA: " + student.getGPA());
			}
		}
	}

}
