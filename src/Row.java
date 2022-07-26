
/**
 * 
 * Student name
 * 
 * 
 * Student ID
 * 
 * 
 * Maintains an integer value representing a SeatLayout row number 1..10
 * 
 * 
 * */
public class Row 
{

	

	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * Constructor with an input row number.
	 * 
	 * */
	
	private int row;
	
	public Row(int number)
	{
		this.row = number;
	}
	
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method
	 * 
	 * */
	public int getNumber() 
	{
		return this.row-1;
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * set method
	 * 
	 * */
	public void setNumber(int number) 
	{
		this.row = number;
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * Two rows are equal if they have the same row number
	 * 
	 * */
	@Override
	public boolean equals(Object o)
	{
		Row number = (Row) o;
		
		if(this.row == number.row)
			return true;
		
		
		return false;
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * String representation of the row.
	 * 
	 * */
	public String toString()
	{
		
		return "Row = " + row;
	}
	//----------------------------------------------------------------------------------------------
}
