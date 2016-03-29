package chesspieces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to represent a Chess Piece. 
 * A chess piece has a square where it is located.
 * And contains the offset of its potential moves.
 * 
 * Therefore its possible moves can be calculated.
 * 
 * @author Carlos Cambon
 *
 */
public class Piece {

	/**
	 * Piece ability to move
	 */
	protected int[][] legalOffset;

	protected Square square;

	protected Map<Square, List<Square>> movesCache = new HashMap<Square, List<Square>>();

	protected Piece(Square square, int[][] legalOffset) {
		this.square = square;
		this.legalOffset = legalOffset;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	protected void setLegalOffset(int[][] legalOffset) {
		this.legalOffset = legalOffset;
	}

	public List<Square> getPosibleMoves() {
		if (movesCache.containsKey(square)) {
			return movesCache.get(square);
		}
		List<Square> posibleMoves = new ArrayList<Square>();
		for (int[] offset : legalOffset) {
			Square move = Square.getSquare(square.x + offset[0], square.y + offset[1]);
			if (move != null) {
				posibleMoves.add(move);
			}
		}
		movesCache.put(square, posibleMoves);
		return posibleMoves;
	}

	public static Piece getInstance(ChessPiece chessPiece, byte squareNumber) {
		switch (chessPiece) {
		case BISHOP:
			return new Bishop(Square.getSquare(squareNumber));
		case KING:
			return new King(Square.getSquare(squareNumber));
		case KNIGHT:
			return new Knight(Square.getSquare(squareNumber));
		case PAWN:
			return new Pawn(Square.getSquare(squareNumber));
		case QUEEN:
			return new Queen(Square.getSquare(squareNumber));
		case ROOK:
			return new Rook(Square.getSquare(squareNumber));
		}
		return null;

	}
}
