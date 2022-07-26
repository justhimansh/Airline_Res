
/**
 * 
 * Student name
 * 
 * 
 * Student ID
 * 
 * 
 *  Position refers to a seat's row and column location within the SeatLayout class 
 * 
 * 
 * */
public class Position 
{


	
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Constructor with input for row and column
	 * 
	 * */
	
	private Column column;
	private Row row;
	
	public Position(Row row, Column column)
	{
		this.row = row;
		this.column = column;
	}	
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * returns a string representation of the position object. e.g. (5,E)
	 * 
	 * */
	public String toString()
	{
		return "Position column=" +column+ ", row=" +row+ "]";
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method
	 * 
	 * */
	public Column getColumn() 
	{
		return column;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method
	 * 
	 * */
	public Row getRow() 
	{
		return row;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Two Position objects are equal if they have equal row numbers and column letters
	 * 
	 * */
	@Override	
	public boolean equals(Object o)
	{
	
		
		
		return false;
		
	}
	//------------------------------------------------------------------------------------------------------------------------
}
