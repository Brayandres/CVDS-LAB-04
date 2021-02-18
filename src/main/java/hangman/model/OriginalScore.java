package hangman.model;

public class OriginalScore implements GameScore {

	/**
	 * @pre
	 * @pos
	 * @param correctCount   Number that indicates the number of letters hit.
	 * @param incorrectCount Number that indicates the number of incorrect letters.
	 * @return Number with weighted score or 0.
	 * @throws HangmanException INVALID_VALUE when some value is invalid or
	 *                          negative.
	 */
	@Override
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {
		if (correctCount < 0 || incorrectCount < 0)
			throw new HangmanException(HangmanException.INVALID_VALUE);
		return (100 - (10 * incorrectCount) < 0) ? 0 : 100 - (10 * incorrectCount);
	}
}