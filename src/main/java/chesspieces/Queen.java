package chesspieces;


public class Queen extends Piece {
	private static final int[][] QUEEN_LEGAL_OFFSET = new int[][]{
		{0,0},
		{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},
		{2,0},{2,2},{0,2},{-2,2},{-2,0},{-2,-2},{0,-2},{2,-2},
		{0,3},{0,-3}
	};

	public Queen(Square square) {
		super(square, QUEEN_LEGAL_OFFSET);
	}

}
