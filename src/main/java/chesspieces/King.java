package chesspieces;


public class King extends Piece {
	private static final int[][] KING_LEGAL_OFFSET = new int[][]{
		{0,0},
		{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}
	};

	public King(Square square) {
		super(square, KING_LEGAL_OFFSET);
	}

	
}
