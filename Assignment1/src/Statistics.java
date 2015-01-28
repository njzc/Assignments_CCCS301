/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 1 
	5.Where you developed your program: Eclipse
*/

import java.text.DecimalFormat;
import java.util.Scanner;


public class Statistics {

	private static double series[] = new double[10];
	
	private static final double NO_REPEAT = -9999;
	
	public static void main(String args[])
	{

		Scanner input = new Scanner(System.in);
		int count = 0;
		
		// decimal display pattern
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#.#####");
		
		// read 10 numbers into series
		while ( count < 10 )
		{
			System.out.print("Please enter No." + ( count + 1) + " number, which should be a real number: ");
			double number = input.nextDouble();
			
			series[count] = number;
			count++;
			System.out.println("Store " + df.format(number) + " in the series successfully.");
		}
		input.close();
		
		// display series
		System.out.println();
		System.out.print("Series: ");
		for(int i = 0; i < series.length; i++)
		{
			System.out.print(df.format(series[i]) + " ");
		}
		System.out.println();
		
		// do the calculation
		double theAverage = average();
		double theGreatest = greatest();
		boolean monotonic = isMonotonic();
		double theMostFrequent = mostFrequent();
		
		// display theAverage value
		System.out.println("Average: " + df.format(theAverage));
		
		// display theGreatest value
		System.out.println("Greatest: " + df.format(theGreatest));
		
		// display isMonotonic value
		System.out.println("Monotonic: " + (monotonic ? "yes" : "no" ));
		
		// display theMostFrequent value
		System.out.print("Most Frequent: ");
		if (theMostFrequent == NO_REPEAT)
		{
			System.out.println("No repeat numbers");			
		}
		else
		{
			System.out.println(df.format(theMostFrequent));
		}

	}
	
	// get the average of the numbers in the series
	static double average()
	{
		double sum = 0;
		
		for(int i = 0; i< series.length; i++)
		{
			sum += series[i];
		}
		
		return sum / series.length;
	}
	
	// get the greatest number in the series
	static double greatest()
	{
		double max = series[0];
		
		for(int i = 1; i< series.length; i++)
		{
			if (series[i] > max)
			{
				max = series[i];
			}
		}
		
		return max;
	}
	
	// check if the array is monotonic
	static boolean isMonotonic()
	{
		// check if the array progressively increases 
		boolean increaseResult = true;		
		for(int i = 0; i< series.length - 1; i++)
		{
			if (series[i] >= series[i + 1])
			{
				increaseResult = false;
				break;
			}
		}
		
		if ( !increaseResult)
		{
			// check if the array progressively decreases 
			boolean decreaseResult = true;
			for(int i = 0; i< series.length - 1; i++)
			{
				if (series[i] <= series[i + 1])
				{
					decreaseResult = false;
					break;
				}
			}
			return decreaseResult;
		}
		else
		{
			return increaseResult;
		}

	}
	
	//get most frequent number in the series
	private static double mostFrequent()
	{
		double repeatNumber = series[0];
		double mostFrequentNumber = series[0];
		int repeatTimes = 1;
		int mostRepeatTimes = 1;
		
		for(int i = 1; i< series.length; i++)
		{
			if (series[i] == repeatNumber)
			{
				repeatTimes++;
			}
			else
			{
				repeatNumber = series[i];
				repeatTimes = 1;
			}
			
			if (repeatTimes > mostRepeatTimes)
			{
				mostRepeatTimes = repeatTimes;
				mostFrequentNumber = repeatNumber;
			}
		}
				
		// only return the number which repeats at least 2 times 
		if (mostRepeatTimes >= 2)
		{
			return mostFrequentNumber;
		}
		else
		{
			return NO_REPEAT;
		}
	}
}
