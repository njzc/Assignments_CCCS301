/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 4 
	5.Where you developed your program: Eclipse
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileStatistics {

	public static void main(String[] args) {
		
		boolean fileIsValid = false;
		boolean tryAgain = false;
		
		System.out.println("** Compute File Statistics **");
		
		Scanner scanner = new Scanner(System.in);

		do 
		{
			System.out.print("Please input file name: ");
			String fileName = scanner.nextLine();
			try
			{
				computeStatistics(fileName);
				fileIsValid = true;
				
				System.out.print("Would you like to perform statistics for another file? (Y/N): ");
				tryAgain = (scanner.nextLine().equalsIgnoreCase("Y"));
			} 
			catch (FileNotFoundException fileNotFoundEx) 
			{
				System.out.println("The file " + fileName + " does not exist or it could not be opened. Please try again.");
			}
			catch (EmptyFileException emptyFileEx)
			{
				System.out.println("The file " + fileName + " is empty. Please try again.");
			}

			
		}while (fileIsValid == false || tryAgain == true);

		scanner.close();
		
		System.out.println("End of program.");
	}

	private static void computeStatistics(String fileName) throws FileNotFoundException, EmptyFileException
	{	

		Scanner scanner = new Scanner(new File(fileName));
		if (!scanner.hasNext()) {
			scanner.close();
			throw new EmptyFileException("Empty File Exception");
		} 
		else 
		{
			int charCount = 0;
			int wordCount = 0;
			int sentenceCount = 0;
			int longest = 0;

			scanner.useDelimiter("\\."); // use period as delimiter

			while (scanner.hasNext()) {
				String sentence = scanner.next();
				sentenceCount++;
				charCount += count(sentence, "");

				int wordCountOfCurrentSentence = count(sentence,
						"\\p{Punct}|\\p{Space}");
				wordCount += wordCountOfCurrentSentence;

				longest = wordCountOfCurrentSentence > longest ? wordCountOfCurrentSentence
						: longest;
			}

			// add number of periods
			charCount = charCount + sentenceCount;

			scanner.close();

			// print out the result
			System.out.println("Total number of characters: " + charCount);
			System.out.println("Total number of words: " + wordCount);
			System.out.println("Total number of sentences: " + sentenceCount);
			System.out.println("Longest sentence: " + longest + " words");
			System.out.println();
		}
	}
	

	private static int count(String inputString, String delimiter)
	{
		int count = 0;
		Scanner scanner = new Scanner(inputString);
		scanner.useDelimiter(delimiter);
		while (scanner.hasNext())
		{
			String next = scanner.next();
			if ( !next.isEmpty() && !next.equals("\n") && !next.equals("\r") ) //ignore empty string or newline string
			{
				count++;
			}
		}
		scanner.close();
		return count;
	}
}
