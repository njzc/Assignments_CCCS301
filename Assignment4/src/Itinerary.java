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
	
	public boolean move(int fromIndex, int toIndex)
	{
		String item = theItinerary.delete(fromIndex);
		return insert(item, toIndex);
	}
	
	//return html string so it can be wrapped
	public String toString()
	{
		String result = "<html>" + title + ":<br />";
		
		Queue<String> tempItinerary = theItinerary.clone();
		String iteneraryItem = tempItinerary.dequeue();
		int index = 1;
		while ( iteneraryItem != null )
		{
			result += index + ": " + iteneraryItem + " <br />";
			iteneraryItem = tempItinerary.dequeue();
			index++;
		}
		
		result += "</html>";
		
		return result;
	}
}
