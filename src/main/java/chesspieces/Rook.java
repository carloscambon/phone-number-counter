package chesspieces;


public class Rook extends Piece {
	private static final int[][] ROOK_LEGAL_OFFSET = new int[][]{
		{0,0},
		{1,0},{0,1},{-1,0},{0,-1},
		{2,0},{0,2},{-2,0},{0,-2},
		{0,3},{0,-3}
	};

	public Rook(Square square) {
		super(square, ROOK_LEGAL_OFFSET);
	}
	
}
