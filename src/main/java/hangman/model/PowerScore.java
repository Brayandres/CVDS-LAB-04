package hangman.model;

public class PowerScore implements GameScore {

	/**
	 * @pre
	 * @pos
	 * @param correctCount   Number that indicates the number of letters hit.
	 * @param incorrectCount Number that indicates the number of incorrect letters.
	 * @return Number with weighted score, 0 or 500.
	 * @throws HangmanException INVALID_VALUE when some value is invalid or
	 *                          negative.
	 */
	@Override
	public int calculateScore(int correctCount, int incorrectCount) throws HangmanException {
		if (correctCount < 0 || incorrectCount < 0)
			throw new HangmanException(HangmanException.INVALID_VALUE);
		int bonus = (5 * ((int) Math.pow(5, correctCount) - 1)) / 4, penalty = incorrectCount * 8,
				total = bonus - penalty;
		if (total < 0) {
			total = 0;
		} else {
			total = (total > 500) ? 500 : total;
		}
		return total;
	}
}