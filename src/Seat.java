
/**
 * 
 * Student name 
 * 
 * Student ID
 * 
 * Student Course code
 *  
 * */
public class Seat 
{
	//static variables to assist code readability
	static public final boolean FIRST_CLASS = true;
	static public final boolean ECONOMY_CLASS = !FIRST_CLASS;

	

	//---------------------------------------------------------------------------------
	/**
	 * Constructor initialses the position and type of the seat with input.
	 * All boolean instance variables to false
	 * */
	private SeatType seatType;
	private Position position;
	private boolean firstClass;
    private boolean reserved;
    
	public Seat(SeatType type,Position position)
	{		
		this.seatType = type;
		this.position = position;
	}
	//---------------------------------------------------------------------------------
	/**
	 * get method for the firstClass instance variable.
	 * */
	public boolean isFirstClass() 
	{
		return firstClass;
	}
	//---------------------------------------------------------------------------------
	/**
	 * set method for the firstClass instance variable
	 * */
	public void setFirstClass(boolean firstClass) 
	{
		this.firstClass = FIRST_CLASS;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * Get method for the type instance variable
	 * 
	 * */
	public SeatType getType()
	{
		return seatType;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * Get method for the reserved instance variable
	 * 
	 * */
	public boolean isReserved()
	{
		return reserved;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * set method for the reserved instance variable
	 * 
	 * */
	public void setReserved(boolean reserved)
	{		
		this.reserved = reserved;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * get method for the position instance variable
	 * 
	 * */
	public Position getPosition() 
	{
		return position;
	}
	//---------------------------------------------------------------------------------
	/**
	 * 
	 * Returns a concise string representation of a Seat object 
	 * A[X] = AISLE seat in first class, reserved.
	 * w[ ] = WINDOW seat in econcomy, not reserved
	 * M[ ] = MIDDLE seat in first class, not reserved
	 * */
	public String toString()
	{
		
		return "Seat FIRST_CLASS=" + FIRST_CLASS + ", position=" 
		        + position + ", reserved=" + reserved + ", seatType=" + seatType;
	}
	//---------------------------------------------------------------------------------
	
	//trying to fix errors
	
	public void setPosition(Position translate) {
		
		this.position = translate;
		
	}
	public void setSeatType(SeatType seatType2) {
		this.seatType = seatType2;
	}
	
}