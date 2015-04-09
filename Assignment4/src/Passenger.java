/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 4 
	5.Where you developed your program: Eclipse
*/

public class Passenger {
	
	private Itinerary itinerary;
	private String name;
	private int seatRow;
	private int seatColumn;
	private int planeID;
	
	public Passenger(String nameOfPassenger)
	{
		this.name = nameOfPassenger;
		this.itinerary = new Itinerary(this.name + "'s Itinerary");
	}

	public String getName()
	{
		return name;
	}
	
	public void setSeatRow(int seatRow)
	{
		this.seatRow = seatRow;
	}
	
	public int getSeatRow()
	{
		return seatRow;
	}
	
	public void setSeatColumn(int seatColumn)
	{
		this.seatColumn = seatColumn;
	}
	
	public int getSeatColumn()
	{
		return seatColumn;
	}
	
	public void setPlaneID(int planeID)
	{
		this.planeID = planeID;
	}
	
	public int getPlaneID()
	{
		return planeID;
	}
	
	public Itinerary getItinerary()
	{
		return itinerary;
	}
}
