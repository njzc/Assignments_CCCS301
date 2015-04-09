/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 4 
	5.Where you developed your program: Eclipse
*/

public class Itinerary {

	private Queue<String> theItinerary;
	private String title;
	
	public Itinerary(String title)
	{
		this.title = title;
		theItinerary = new Queue<String>();
	}
	
	public boolean add(String item)
	{
		return theItinerary.enqueue(item);
	}
	
	public boolean delete(int index)
	{
		if ( theItinerary.delete(index) != null )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean insert(String item, int index)
	{
		return theItinerary.insert(item, index);
	}
	
	public String toString()
	{
		String result = title + ": ";
		
		Queue<String> tempItinerary = theItinerary.clone();
		String iteneraryItem = tempItinerary.dequeue();
		int index = 1;
		while ( iteneraryItem != null )
		{
			result += index + ": " + iteneraryItem + ", ";
			iteneraryItem = tempItinerary.dequeue();
			index++;
		}
		
		//remove last ", "
		if ( result.endsWith(", "))
		{
			result = result.substring(0, result.length() - 2);
		}
		
		return result;
	}
}
