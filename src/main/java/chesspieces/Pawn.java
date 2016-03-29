package chesspieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
	private static final int[][] PAWN_LEGAL_OFFSET = new int[][] {
			// This moves are proper to the Pawn
			{ 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 1 }, { -1, 1 } 
			};

	private static final int[][] QUEEN_LEGAL_OFFSET = new int[][] {
			// These are the moves for the Queen movements when Pawn crowns
			{0,0},
			{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},
			{2,0},{2,2},{0,2},{-2,2},{-2,0},{-2,-2},{0,-2},{2,-2},
			{0,3},{0,-3}
			};

	public Pawn(Square square) {
		super(square, PAWN_LEGAL_OFFSET);
	}

	private boolean pawnIsQueen;

	@Override
	public List<Square> getPosibleMoves() {
		List<Square> posibleMoves = new ArrayList<Square>();

		// Filtering out moves
		
		// 2. When Pawn has crowned, can move as a Queen
		if (pawnIsQueen) {
			setLegalOffset(QUEEN_LEGAL_OFFSET);
			return super.getPosibleMoves();
		}
		
		// 1. When Pawn arrives to the 1, 2, 3 row, 
		// it can only move to its current square
		if (square.y == 1) {
			posibleMoves.clear();
			posibleMoves.add(Square.getSquare(0, 0));
			pawnIsQueen = true;
			return posibleMoves;
		}
		
		return super.getPosibleMoves();

	}

}
