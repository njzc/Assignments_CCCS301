/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 4 
	5.Where you developed your program: Eclipse
*/

import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);

		Queue<Integer> queue = new Queue<Integer>();
		for (int i = 0; i < 14; i++)
		{
			queue.enqueue(i);
		}
		queue.insert(100,2);
		System.out.println(queue);
		System.out.println(queue.delete(11));
		System.out.println(queue);
		scanner.close();
		
	}

}
