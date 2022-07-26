
/**
 * 
 * Himansh Kohli
 * 
 * 
 * 20112429
 * 
 * 
 *  AirlineReservation class contains a SeatLayout 
 *  and methods to reserve seats
 * 
 * 
 * */
public class AirlineReservation {


	
	private Row row;
	private Column column;

	//------------------------------------------------------------------
	public SeatLayout getSeatLayout()
	{
		
		return null;
		
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * Reserves a seat according to the row and column.
	 * returns true if the seat reservation was successful and false otherwise.
	 *
	 * */
	public boolean reserveSeat(Row row, Column column)
	{		
		this.row = row;
		this.column = column;
		
		
		

		return false;
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * 
	 * Reserves an unreserved seat according to firstClass and the seatType.
	 * 
	 * */
	public Seat reserveAvailableSeatType(boolean firstClass,SeatType type)
	{

		return null;
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * Takes as input a seatLayout parameter to set the instance variable
	 * 
	 * */
	public AirlineReservation(SeatLayout seatLayout)
	{
					
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * String representation of the AirlineReservation.
	 * 
	 * An example output is the toString from seatlayout and some availability statistics
	 * 
	 * ----------------------------------
	 * W[ ] A[X] A[ ] M[X] A[ ] A[ ] W[ ] 
	 * W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
	 * W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
	 * W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
	 * w[X] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
	 * ----------------------------------
	 * # Window seats available: 19
	 * # Aisle seats available: 39
	 * # Middle seats available: 9
	 * 
	 * */
	public String toString()
	{
		return null;
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * 
	 * Reserves an entire column of seats.
	 * You do not need to check if the seats are already reserved -- simple reserve them.
	 * 
	 * */
	public void reserveColumn(Column column)
	{
		
		
		
		
	}
	//------------------------------------------------------------------
	/**
	 * 
	 * 
	 * Reserves an entire row of seats.
	 * You do not need to check if the seats are already reserved -- simple reserve them.
	 * 
	 * */
	public void reserveRow(Row row) 
	{
	
	}
	//------------------------------------------------------------------

}