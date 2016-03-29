package chesspieces;

public class Bishop extends Piece {
	private static final int[][] BISHOP_LEGAL_OFFSET = new int[][]{
		{0,0},
        {1,1},{-1,1},{-1,-1},{1,-1},
        {2,2},{-2,2},{-2,-2},{2,-2},
	};

	public Bishop(Square square) {
		super(square, BISHOP_LEGAL_OFFSET);
	}

}
