
/**
 * 
 * Student name
 * 
 * 
 * Student ID
 * 
 * 
 *  Column class stores a letter refering to a column of seats in the SeatLayout
 * 
 * 
 * */
public class Column {

	private char column;
	
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method
	 * 
	 * */	
	public char getLetter() {
		return column;
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * Set method
	 * 
	 * */
	public void setLetter(char letter) {
		
		this.column = letter;
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * Constructor takes as input a character representing the column letter
	 * 
	 * */
	
	//done at line 16
	
	public Column(char letter)
	{
		column = letter;
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * Two columns are equal when their letters match (case sensitive)
	 * 
	 * */
	@Override 
	public boolean equals(Object o)
	{	
		Column column = (Column) o;
		
		if(this.column == column.column);
			return true;
			
	}
	//----------------------------------------------------------------------------------------------
	/**
	 * 
	 * returns  the letter of the column as a string.
	 * 
	 * */
	public String toString()
	{
		return "Column = " + column;
	}
	//----------------------------------------------------------------------------------------------
}
