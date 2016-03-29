package chesspieces;


public class Knight extends Piece {
	private static final int[][] KNIGHT_LEGAL_OFFSET = new int[][]{
		{0,0},
        {1,2},{2,1},{2,-1},{1,-2},
        {-1,2},{-2,1},{-2,-1},{-1,-2},
	};

	public Knight(Square square) {
		super(square, KNIGHT_LEGAL_OFFSET);
	}

}
