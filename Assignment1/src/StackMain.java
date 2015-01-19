/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 1 
	5.Where you developed your program: Eclipse
*/

public class StackMain {

	
	public static void main(String[] args) {
		
		TheStack aStack = new TheStack();
		System.out.println(aStack.push(1));
		System.out.println(aStack.push(-2));
		System.out.println(aStack.push(3));
		System.out.println(aStack.push(3));
		
		int popValue = aStack.pop();
		while (popValue != -9999)
		{	
			System.out.println(popValue);
			popValue = aStack.pop();
		}
	}

}
