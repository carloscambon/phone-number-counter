package chesspieces;

/**
 * Enum to hold the posible Chess pieces that can be used to generate phone numbers on the dialing pad
 * @author Carlos Cambon
 *
 */
public enum ChessPiece {
	KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN;

	public static ChessPiece getChessPiece(String chessPiece) {
		chessPiece = chessPiece.toUpperCase();
		for (ChessPiece piece : ChessPiece.values()) {
			if (piece.name().equals(chessPiece)) {
				return piece;
			}
		}
		return null;
	}
}
