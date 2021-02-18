package hangman.model;

public class HangmanException extends Exception {

	private static final long serialVersionUID = 6788907528495282682L;

	public static final String INVALID_VALUE = "INVALID_VALUE";
	public static final String NEGATIVE_VALUE = "NEGATIVE_VALUE";

	public HangmanException(String msg) {
		super(msg);
	}
}