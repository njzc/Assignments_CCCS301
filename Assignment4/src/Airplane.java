/*
	1.Name: Cong Zhang 
	2.ID number: 260573307
	3.Course number: CCCS 301 
	4.Assignment number: 4 
	5.Where you developed your program: Eclipse
*/

public class Airplane {
	
	private Queue<Passenger> passengers;
	private int planeID;
	private boolean seats[][];
	
	public Airplane(int id, int size)
	{
		this.planeID = id;
		seats = new boolean[2][size];
		
		//initialize with empty seats
		for (int i = 0; i < seats.length; i++)
		{
			for (int j = 0; j < seats[i].length; j++)
			{
				seats[i][j] = false;
			}
		}
		
	}
	
	public boolean getSeat(int seatRow, int seatColumn)
	{
		if ( seatRow >= 0 && seatRow < seats.length 
		&& seatColumn >= 0 && seatColumn < seats[0].length )
		{
			return seats[seatRow][seatColumn];
		}
		
		return false;
	}
	
	public void setSeat(int seatRow, int seatColumn)
	{
		if ( seatRow >= 0 && seatRow < seats.length 
		&& seatColumn >= 0 && seatColumn < seats[0].length )
		{
			seats[seatRow][seatColumn] = true;
		}
	}
	
	public int getID()
	{
		return planeID;
	}
	
	//TODO: TBD
	public Passenger getPassenger()
	{
		return passengers.dequeue();
	}
}
