

public class SeatLayout 
{
	private final char OFFSET_LETTER = 'A';
	
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Constructor takes as input and sets the number of rows and columns
	 * must invoke the initialise() method.
	 * 
	 * 
	 * */
	
	private int totalNumberOfRow, totalNumberOfColumn;
	private Seat seats[][];
	
	public SeatLayout(int numberOfRows,int numberOfColumns)
	{
		   this.totalNumberOfRow = numberOfRows;
	       this.totalNumberOfColumn = numberOfColumns;
		
		this.initialise();		
	}	
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * initialises the seats two-dimensional array as shown on the 
	 * right hand side of Figure 1 of the assignment brief.
	 * 
	 * */
	private void initialise()
	{	
				
		seats = new Seat[totalNumberOfRow][totalNumberOfColumn];

	      for(int i=0; i<totalNumberOfRow; i++)
	      {
	          for(int k=0; k< totalNumberOfColumn; k++)
	          {
	              seats[i][k].setPosition(translate(i, k));
	              seats[i][k].setReserved(false);
	              seats[i][k].setSeatType(seatType(k));

	              if(i < 4) {
	                seats[i][k].setFirstClass(true);
	              }
	            else {
	                seats[i][k].setFirstClass(false);
	          }
	          } }
		
	}
	//------------------------------------------------------------------------------------------------------------------------
	/***
	 * 
	 * Translates 2 dimensional array indicies (i,j) to a row column pair, returned as a new Position object.
	 *  
	 *    translate(0,0) returns Position with Row = 1 and Column = 'A'
	 *    translate(1,2) returns Position with Row = 2 and Column = 'B'
	 *    translate(2,2) returns Position with Row = 3 and Column = 'C' 
	 */
	private Position translate(int i,int j)
	{
		Row row = new Row(i + 1);
	    Column col = new Column((char)(OFFSET_LETTER + j));
	    Position pos = new Position(row, col);

	       return pos;
		
		
		
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * Translates a row to an i-index of the 2-dim array.
	 * translate(1) = 0
	 * translate(2) = 1 etc..
	 * */	
	private int translate(Row row)
	{
		return row.getNumber();
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Translates a Column object to a j-index of the 2-dim array. Use OFFSET_LETTER final var
	 * translate('A') = 0
	 * translate('B') = 1
	 * translate('C') = 2
	 * 
	 * */
	private int translate(Column column)
	{
		
		return (int)column.getLetter();
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns the correct seat type given a j index for the seat layout 
	 * 
	 * 
	 * */
	private SeatType seatType(int j)
	{
		if(j == 0 || j == 6) {
			return SeatType.WINDOW;
		}
		if(j == 3) {
			return SeatType.MIDDLE;
		}
		else {
			return SeatType.AISLE;
		}
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Given a position p, return the corresponding Seat.
	 * 
	 * If the position is not valid then return null.
	 * 
	 * */
	public Seat getSeat(Position p)
	{		
		int column = translate(p.getColumn());
		int row = translate(p.getRow());
		
	    if(row <= 0 || row >= totalNumberOfRow) {
	        	
	    	return null;
	    }
	    else if(column <= 0 || column >= totalNumberOfColumn) {
	    	
	    	return null;
	    }
		return seats[row][column];
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns a string representation of the seat layout similar to Figure 1 
	 * 
	 * */
	public String toString()
	{	
		return null;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * get method for seats instance variable
	 * */
	public Seat[][] getSeats()
	{		
		return seats;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns a row of seat objects.
	 * 
	 * 
	 * If the input row is not valid, then an empty array of Seat objects is returned.
	 * 
	 * 
	 * */
	public Seat[] getRowOfSeats(Row row)
	{		
		int Row = translate(row);

	       if(Row <0 || Row >= totalNumberOfRow) 
	            return new Seat[totalNumberOfColumn];
	        			return seats[Row];
	       }
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns a column of seat objects.
	 * 
	 * 
	 * If the input column is not valid, then an empty array of Seat objects is returned.
	 * 
	 * 
	 * */
	public Seat[] getColumnOfSeats(Column column) 
	{
		int Column = translate(column);

        Seat seatLayout[] = new Seat[totalNumberOfRow];

        if(Column <0 || Column >= totalNumberOfColumn)
             return seatLayout;

        for(int k=0; k< totalNumberOfRow; k++)
            seatLayout[k] = seats[k][Column];

        return seatLayout;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method for the number of rows
	 * 
	 * */
	public int getNumberOfRows()
	{
		return totalNumberOfRow;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * get method for the number of columns
	 * 
	 * */
	public int getNumberOfColumns()
	{
		return totalNumberOfColumn;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Counts and returns the amount of unreserved seats of the input type.
	 * 
	 * */
	public int getAvailabileAmount(SeatType type) 
	{
		int k = 0;

	       for(int i=0; i< totalNumberOfRow; i++)
	       {
	           for(int t=0; t< totalNumberOfColumn; t++)
	           {
	               if(seats[i][t].getType() == type)
	                    if(! seats[i][t].isReserved())
	                    k++;
	           }}
	       return k;
	}
	//------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Returns any seat that matches firstClass and the seat type and is unreserved.
	 * 
	 * If no such seat is available then null is returned.
	 * 
	 * */
	public Seat getAvailableSeatType(boolean firstClass, SeatType type) 
	{	
		for(int i = 0; i <= totalNumberOfRow; i++) {
			for(int l = 0; l <= totalNumberOfColumn; l++) {
				
				if(seats [i][l].getType() == type && seats[i][l].isFirstClass()) {
					if(!seats[i][l].isReserved()) {
						return seats[i][l];
					}
				}
			}
		}
		return null;
	}
	
		
		
	
	//------------------------------------------------------------------------------------------------------------------------
}
