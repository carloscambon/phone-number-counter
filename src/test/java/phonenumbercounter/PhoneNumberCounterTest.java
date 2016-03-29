package phonenumbercounter;

import org.junit.Test;

import chesspieces.ChessPiece;

public class PhoneNumberCounterTest {

	private static final byte FIRST_DIGIT = 5;
	private static final byte MAX_DIGITS = 10;

	@Test
	public void phoneNumbersGeneratedWithAQueenFromSquareFive() {
		long phoneNumbersGenerated = PhoneNumberCounter.getNumberOfPhoneNumbers(ChessPiece.QUEEN, FIRST_DIGIT, MAX_DIGITS);
		long expected = 124768940;
		org.junit.Assert.assertTrue(expected == phoneNumbersGenerated);
	}

	@Test
	public void phoneNumbersGeneratedWithABishopFromSquareFive() {
		long phoneNumbersGenerated = PhoneNumberCounter.getNumberOfPhoneNumbers(ChessPiece.BISHOP, FIRST_DIGIT, MAX_DIGITS);
		long expected = 225401;
		org.junit.Assert.assertTrue(expected == phoneNumbersGenerated);
	}

	@Test
	public void phoneNumbersGeneratedWithAKnightFromSquareFive() {
		long phoneNumbersGenerated = PhoneNumberCounter.getNumberOfPhoneNumbers(ChessPiece.KNIGHT, FIRST_DIGIT, MAX_DIGITS);
		long expected = 1;
		org.junit.Assert.assertTrue(expected == phoneNumbersGenerated);
	}

	@Test
	public void phoneNumbersGeneratedWithARookFromSquareFive() {
		long phoneNumbersGenerated = PhoneNumberCounter.getNumberOfPhoneNumbers(ChessPiece.ROOK, FIRST_DIGIT, MAX_DIGITS);
		long expected = 3685592;
		org.junit.Assert.assertTrue(expected == phoneNumbersGenerated);
	}
	
	@Test
	public void phoneNumbersGeneratedWithAKingFromSquareFive() {
		long phoneNumbersGenerated = PhoneNumberCounter.getNumberOfPhoneNumbers(ChessPiece.KING, FIRST_DIGIT, MAX_DIGITS);
		long expected = 14568235;
		org.junit.Assert.assertTrue(expected == phoneNumbersGenerated);
	}
	
	@Test
	public void phoneNumbersGeneratedWithAPawnFromSquareFive() {
		long phoneNumbersGenerated = PhoneNumberCounter.getNumberOfPhoneNumbers(ChessPiece.PAWN, FIRST_DIGIT, MAX_DIGITS);
		long expected = 115731596;
		org.junit.Assert.assertTrue(expected == phoneNumbersGenerated);
	}

}
