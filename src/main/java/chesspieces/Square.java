package chesspieces;

/**
 * This enum signifies the Dialing pad digits as in:
 * 
 *     1 2 3 
 *     4 5 6 
 *     7 8 9 
 *     * 0 #
 *     
 *     where hash and asterisk are not valid squares.
 *     
 *     x and y are the coordinates of the square, being (0,0) the square FIVE.
 *     
 * @author Carlos Cambon
 *
 */
public enum Square {
	ONE (1, -1, 1),
	TWO (2, 0, 1),
	THREE (3, 1, 1),
	FOUR (4, -1, 0),
	FIVE (5, 0, 0),
	SIX (6, 1, 0),
	SEVEN (7, -1, -1),
	EIGHT (8, 0, -1),
	NINE (9, 1, -1),
	CERO (0, 0, -2);
	
	int x;
	int y;
	int digit;

	Square (int digit, int x, int y) {
		this.digit = digit;
		this.x = x;
		this.y = y;
	}
	
	public static Square getSquare (int x, int y) {
		for (Square square : Square.values()) {
			if (square.x == x && square.y == y) {
				return square;
			}
		}
		return null;
	}
	
	public static Square getSquare (int digit) {
		for (Square square : Square.values()) {
			if (square.digit == digit) {
				return square;
			}
		}
		return null;
	}
}
