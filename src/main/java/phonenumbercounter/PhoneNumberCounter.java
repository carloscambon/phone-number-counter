package phonenumbercounter;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import chesspieces.ChessPiece;
import chesspieces.Piece;
import chesspieces.Square;

/**
 * Class that takes the name of a chess piece (King, Queen, Bishop, Knight, Rook, Pawn) and a starting digit, 0 to 9.
 * As output gives the count all the legal phone numbers, beginning with the starting digit, 
 * that can be generated by moving the piece around a standard phone pad.
 * 
 * A legal phone number has the following requirements: 
 * 
 *   - Must be 10 digits long
 *   - Can contain only digits (no * or #) 
 *   
 *   The phone pad layout is
 *   
 *   1 2 3
 *   4 5 6
 *   7 8 9
 *   * 0 #
 *   
 * @author Carlos Cambon
 *
 */
public class PhoneNumberCounter {
	public static final byte MAX_DIGITS = 10;
	
	/**
	 * This Cache stores the amount of possible moves for the piece at each digit level, i.e, 
	 * starting at the right side of the phone number and working its way to the left.
	 * This speeds up the counting of the phone numbers.
	 */
	private static Map<Integer, Map<Square, Long>> movesByDigitPositionCache = new HashMap<Integer, Map<Square, Long>>();

	private void init(Piece chessPiece) {
		// Initializing cache
		for (int i = 1; i < MAX_DIGITS; i++) {
			movesByDigitPositionCache.put(i, new HashMap<Square, Long>());
		}
		fillCache(chessPiece);
	}

	private void fillCache(Piece chessPiece) {
		for (int j = MAX_DIGITS -1; j > 0; j--) {
			fillCacheLevel(chessPiece, j);
		}
	}
	
	static long getNumberOfPhoneNumbers(ChessPiece chessPiece, byte firstDigit, int numberOfDigits) {
		PhoneNumberCounter phoneNumberCounterInstance = new PhoneNumberCounter();
		// First filling up the cache of all possible moves of that chess piece in each digit position
		phoneNumberCounterInstance.init(Piece.getInstance(chessPiece, firstDigit));
		// Now simply returning the count of the phone numbers that can be generated starting with that digit
		return movesByDigitPositionCache.get(1).get(Square.getSquare(firstDigit));
	}

	/**
	 * This method fills up the Cache counting the possible moves of the chess piece passed in at each digit position.
	 * @param chessPiece
	 * @param digitPositionCache
	 */
	private void fillCacheLevel(Piece chessPiece, int digitPositionCache) {
		// We iterate through each square to fill all square combinations in the cache
		for (Square square : Square.values()) {
			long result = 0l;
			chessPiece.setSquare(square);
			// If we are not at the extreme right of the phone number, we get the value from 
			// the next cache level since that is already filled up 
			if (movesByDigitPositionCache.get(digitPositionCache + 1) != null) {
				for (Square lowerLevelMove : chessPiece.getPosibleMoves()) {
					result += movesByDigitPositionCache.get(digitPositionCache + 1).get(lowerLevelMove);
				}
			} else {
				// Being at the end right of the phone number, we calculate the posible moves of the piece
				result = chessPiece.getPosibleMoves().size();
			}

			movesByDigitPositionCache.get(digitPositionCache).put(square, result);
		}
	}


	public static void main(String[] args) {
		// Need to get a chess piece and a dialing pad position
		Scanner reader = new Scanner(System.in);  // Reading from System.in

		try {
			boolean pieceIncorrect = true;
			ChessPiece piece = null;
			do {
				System.out.println("Enter a Chess piece: King, Queen, Rook, Bishop, Knight or Pawn ");
				String chessPiece = reader.next(); 
				piece = ChessPiece.getChessPiece(chessPiece);
				if (piece  == null) {
					System.out.println("That piece was incorrect.");
				} else {
					pieceIncorrect = false;
				}
			} while (pieceIncorrect);
			
			boolean digitIncorrect = true;
			byte firstDigit = 0;
			do {
				reader = new Scanner(System.in);
				System.out.println("Enter the first digit: 1, 2, 3, 4, 5, 6, 7, 8, 9 or 0 ");
				try {
					firstDigit = reader.nextByte();
					Square square = Square.getSquare(firstDigit);
					if (square  == null) {
						System.out.println("That was incorrect.");
					} else {
						digitIncorrect = false;
					}
				} catch (InputMismatchException e) {
					System.out.println("That was incorrect.");
				} 
				
			} while (digitIncorrect);
			
			// Calling the method to get the phone number count with the chess piece and first digit gotten
			System.out.println("TOTAL RESULT: " + PhoneNumberCounter.getNumberOfPhoneNumbers(piece, firstDigit, MAX_DIGITS));
		} catch (Exception e) {
			System.out.println("Unexpected Exception " + e.getMessage());
		} finally {
			reader.close();
		}
		
	}

}
