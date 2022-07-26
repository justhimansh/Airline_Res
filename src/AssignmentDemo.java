
/**
 * 
 * Kenneth Johnson
 * 
 * Student ID
 * 
 * Collection of static methods for testing functionality of the AirlineReservation class and support classes
 * 
 * */
public class AssignmentDemo 
{
	private static AirlineReservation air;
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Output helper method
	 * 
	 * */
	static private void printTitleLine(String title)
	{
		System.out.println("-------------------------------------------------------");
		System.out.println(title+"\n");
	}
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Output helper method
	 * 
	 * */
	static private String asSeatColumn(Seat[] columnSeats)
	{
		String out = "";
		for(Seat seat : columnSeats)
		{
			out+= seat+"\n";
		}
		return out;
	}
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Output helper method
	 * 
	 * */
	static private String asSeatRow(Seat[] rowSeats)
	{
		String out = "";
		for(Seat seat : rowSeats)
		{
			out+= seat+" ";
		}
		return out;
	}
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Helper method for testAirLineReservation
	 * 
	 * */
	static private void reserveAvailableSeatTypeTest(boolean firstClass,SeatType type)
	{
		Seat seat = air.reserveAvailableSeatType(firstClass,type);
		if(seat == null)
		{
			System.out.println("No seat with type "+type.name()+" is available");
		}
		else
		{
			System.out.println("Seat of type "+type+" at position: "+seat.getPosition()+" has been reserved");
		}								
	}
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Helper method for testAirLineReservation
	 * 
	 * */
	static private void reserveRowTest(Row row)
	{		
		System.out.println("Attempting to reserve row "+row.getNumber());
		Seat[] rowOfSeats = air.getSeatLayout().getRowOfSeats(row);
		if(rowOfSeats != null)
		{

			System.out.println(asSeatRow(rowOfSeats));
			air.reserveRow(row);
			System.out.println("Reserving row "+row.getNumber());
			System.out.println(asSeatRow(rowOfSeats));
			System.out.println("");
		}
		else
		{
			System.out.println("Invalid row number supplied");
		}
	}
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Helper method for testAirLineReservation
	 * 
	 * */
	static private void reserveColumnTest(Column column)
	{
		System.out.println("Column "+column);
		Seat[] columnOfSeats = air.getSeatLayout().getColumnOfSeats(column);
		System.out.println(asSeatColumn(columnOfSeats));
		air.reserveColumn(column);
		System.out.println("Reserving column "+column);
		System.out.println(asSeatColumn(columnOfSeats));
	}
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Tests functionality for the Row, Column and Position classes
	 * 
	 * */
	static public void testRowColumnPosition()
	{
		printTitleLine("testRowColumnPosition method");		
		System.out.println("These rows are equal: "+(new Row(1).equals(new Row(1))));
		System.out.println("These rows are not equal: "+(new Row(1).equals(new Row(2))));

		System.out.println("These columns are equal: "+(new Column('A').equals(new Column('A'))));
		System.out.println("These columns are not equal: "+(new Column('B').equals(new Column('C'))));

		Position pos1 = new Position(new Row(5),new Column('C'));
		Position pos2 = new Position(new Row(5),new Column('C'));
		Position pos3 = new Position(new Row(1),new Column('D'));

		System.out.println("These positions are equal: "+pos1.equals(pos2));
		System.out.println("These positions are not equal: "+pos1.equals(pos3));

	}	
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Tests Seat class functionality
	 * 
	 * */
	static public void testSeat()
	{

		printTitleLine("testSeats output");

		System.out.println("AISLE seat in first class, reserved");
		Seat seat = new Seat(SeatType.AISLE,new Position(new Row(1),new Column('B')));
		seat.setFirstClass(Seat.FIRST_CLASS);
		seat.setReserved(true);
		System.out.println(seat);

		System.out.println("WINDOW seat in econcomy class, not reserved");
		seat = new Seat(SeatType.WINDOW,new Position(new Row(5),new Column('A')));
		System.out.println(seat);

		System.out.println("MIDDLE seat in first class, not reserved");
		seat = new Seat(SeatType.MIDDLE,new Position(new Row(2),new Column('D')));
		seat.setFirstClass(Seat.FIRST_CLASS);
		System.out.println(seat);		
	}
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Tests SeatLayout functionality
	 * 
	 * */
	public static void testSeatLayout()
	{
		printTitleLine("testSeatLayout output");
		SeatLayout layout = new SeatLayout(10,7);		
		System.out.println(layout);
		System.out.println("getAvailableSeatType: "+ layout.getAvailableSeatType(Seat.FIRST_CLASS, SeatType.AISLE));
		System.out.println("getAvailableAmount: "+ layout.getAvailabileAmount(SeatType.MIDDLE));
		System.out.println("getColumnOfSeats for D: \n"+ AssignmentDemo.asSeatColumn(layout.getColumnOfSeats(new Column('D'))));
		System.out.println("getColumnOfSeats for invalid column: \n"+ AssignmentDemo.asSeatColumn(layout.getColumnOfSeats(new Column('Z'))));
		System.out.println("getRowOfSeats for 2: "+ AssignmentDemo.asSeatRow(layout.getRowOfSeats(new Row(2))));
		System.out.println("getRowOfSeats for invalid row: "+ AssignmentDemo.asSeatRow(layout.getRowOfSeats(new Row(100))));
		System.out.println("get seat for position (2,E)\n"+layout.getSeat(new Position(new Row(4),new Column('E'))));
		System.out.println("get seat for invalid position\n"+layout.getSeat(new Position(new Row(100),new Column('Z'))));
	}
	//------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * Tests AirLineReservation functionality
	 * 
	 * */
	static public void testAirLineReservation()
	{		
		printTitleLine("testAirLineReservation");
		AssignmentDemo.air = new AirlineReservation(new SeatLayout(10,7));		
		//reserve any available window/aisle/middle seat
		System.out.println("Reserving a first class AISLE seat");
		reserveAvailableSeatTypeTest(Seat.FIRST_CLASS,SeatType.AISLE);
		System.out.println(air);

		System.out.println("Reserving an economy class WINDOW seat");
		reserveAvailableSeatTypeTest(Seat.ECONOMY_CLASS,SeatType.WINDOW);
		System.out.println(air);

		System.out.println("Reserving an economy class MIDDLE seat");
		reserveAvailableSeatTypeTest(Seat.FIRST_CLASS,SeatType.MIDDLE);		
		System.out.println(air);		 
		//reserve a specific seat in the seat layout
		air.reserveSeat(new Row(3),new Column('E'));		
		System.out.println(air);
		//try to reserve a seat that does not exist
		if(!air.reserveSeat(new Row(100),new Column('Z')))
		{
			System.out.println("Reserve Seat Operation Failed!");
		}

		System.out.println(air);

		//reserve an entire row 4		
		reserveRowTest(new Row(4));

		//reserve an entire row 1
		reserveRowTest(new Row(1));

		//try to reserve an invalid row
		reserveRowTest(new Row(100));
		//reserve an entire column D
		reserveColumnTest(new Column('D'));

		//reserve an entire column A
		reserveColumnTest(new Column('A'));

		//try to reserve an invalid column
		reserveColumnTest(new Column('Z'));
	}
	//------------------------------------------------------------------------------------------------------------
	/**
	 * Uncomment lines as you complete the assignment.
	 * */
	public static void main(String[] args) 
	{				
		System.out.println("Welcome to the Airline Reservation System");
		AssignmentDemo.testRowColumnPosition();
		//AssignmentDemo.testSeat();
		//AssignmentDemo.testSeatLayout();
		//AssignmentDemo.testAirLineReservation();

	}
}
/**
 * 
 * Main method output from all classes. 
 * 
 * 
 * Welcome to the Airline Reservation System
-------------------------------------------------------
testRowColumnPosition method

These rows are equal: true
These rows are not equal: false
These columns are equal: true
These columns are not equal: false
These positions are equal: true
These positions are not equal: false
-------------------------------------------------------
testSeats output

AISLE seat in first class, reserved
A[X]
WINDOW seat in econcomy class, not reserved
w[ ]
MIDDLE seat in first class, not reserved
M[ ]
-------------------------------------------------------
testSeatLayout output

W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 

getAvailableSeatType: A[ ]
getAvailableAmount: 10
getColumnOfSeats for D: 
M[ ]
M[ ]
M[ ]
M[ ]
m[ ]
m[ ]
m[ ]
m[ ]
m[ ]
m[ ]

getColumnOfSeats for invalid column: 

getRowOfSeats for 2: W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
getRowOfSeats for invalid row: 
get seat for position (2,E)
A[ ]
get seat for invalid position
null
-------------------------------------------------------
testAirLineReservation

Reserving a first class AISLE seat
Seat of type AISLE at position: (1,B) has been reserved
----------------------------------
W[ ] A[X] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
----------------------------------
# Window seats available: 20
# Aisle seats available: 39
# Middle seats available: 10
Reserving an economy class WINDOW seat
Seat of type WINDOW at position: (5,A) has been reserved
----------------------------------
W[ ] A[X] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
w[X] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
----------------------------------
# Window seats available: 19
# Aisle seats available: 39
# Middle seats available: 10
Reserving an economy class MIDDLE seat
Seat of type MIDDLE at position: (1,D) has been reserved
----------------------------------
W[ ] A[X] A[ ] M[X] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
w[X] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
----------------------------------
# Window seats available: 19
# Aisle seats available: 39
# Middle seats available: 9
----------------------------------
W[ ] A[X] A[ ] M[X] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[X] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
w[X] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
----------------------------------
# Window seats available: 19
# Aisle seats available: 38
# Middle seats available: 9
Reserve Seat Operation Failed!
----------------------------------
W[ ] A[X] A[ ] M[X] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[X] A[ ] W[ ] 
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
w[X] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
w[ ] a[ ] a[ ] m[ ] a[ ] a[ ] w[ ] 
----------------------------------
# Window seats available: 19
# Aisle seats available: 38
# Middle seats available: 9
Attempting to reserve row 4
W[ ] A[ ] A[ ] M[ ] A[ ] A[ ] W[ ] 
Reserving row 4
W[X] A[X] A[X] M[X] A[X] A[X] W[X] 

Attempting to reserve row 1
W[ ] A[X] A[ ] M[X] A[ ] A[ ] W[ ] 
Reserving row 1
W[X] A[X] A[X] M[X] A[X] A[X] W[X] 

Attempting to reserve row 100

Reserving row 100


Column D
M[X]
M[ ]
M[ ]
M[X]
m[ ]
m[ ]
m[ ]
m[ ]
m[ ]
m[ ]

Reserving column D
M[X]
M[X]
M[X]
M[X]
m[X]
m[X]
m[X]
m[X]
m[X]
m[X]

Column A
W[X]
W[ ]
W[ ]
W[X]
w[X]
w[ ]
w[ ]
w[ ]
w[ ]
w[ ]

Reserving column A
W[X]
W[X]
W[X]
W[X]
w[X]
w[X]
w[X]
w[X]
w[X]
w[X]

Column Z

Reserving column Z


 * 
 * 
 * */





