/***************************************************************
* file: GameScoreTest.java
* author:   Brayan Macias
*
* assignment: Lab 04
* date last modified: 17/2/2021
*
* purpose: This is the TestClass that will prove the interface GameScore 
* 		   and the clases that uses it 
* 
*
*                  EQUIVALENCE CLASSES &
*                      LIMIT VALUES
* OriginalScore: 
* 1. Invalid parameters (-1,0), (-2,0), (0,-1), (0,-2)
* 2. Score between 0 and 100  (0,1),(0,0),(1,2)
* 3. Score less than 0 (0,10), (0,11), (0,9)
* 
* BonusScore: 
* 1. Invalid parameters (-1,0), (-2,0), (0,-1), (0,-2)
* 2. Score greater than 0 (1,0), (5,9), (0,0)
* 3. Score less than 0 (5,10), (5,11), (0,0)
* 
* PowerBonusScore: 
* 1. Invalid parameters (-1,0), (-2,0), (0,-1), (0,-2)
* 2. Score between 0 and 500 (3,19), (3,20),(4,0), (0,0)
* 3. Score less than 0 (1,1), (0,1), (0,0)
* 4. Score greater than 500 (4,0) 
****************************************************************/

package hangman;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hangman.model.BonusScore;
import hangman.model.GameScore;
import hangman.model.HangmanException;
import hangman.model.OriginalScore;
import hangman.model.PowerScore;

public class GameScoreTest {

	@Test
	public void invalidParametersOriginalScoreTest() {
		GameScore g = new OriginalScore();
		try {
			g.calculateScore(-1, 0);
		} catch (HangmanException e) {
			assertEquals(e.getMessage(), HangmanException.INVALID_VALUE);
		}

	}

	@Test
	public void invalidParametersBonusScoreTest() {
		GameScore g = new BonusScore();
		try {
			g.calculateScore(0, -1);
		} catch (HangmanException e) {
			assertEquals(e.getMessage(), HangmanException.INVALID_VALUE);
		}

	}

	@Test
	public void invalidParametersPowerScoreTest() {
		GameScore g = new PowerScore();
		try {
			g.calculateScore(0, -2);
		} catch (HangmanException e) {
			assertEquals(e.getMessage(), HangmanException.INVALID_VALUE);
		}

	}

	@Test
	public void scoreBetween0And100OriginalScore() {
		GameScore g = new OriginalScore();
		try {
			int a = g.calculateScore(0, 0);
			int a1 = g.calculateScore(0, 1);
			int a2 = g.calculateScore(1, 2);
			assertEquals(100, a);
			assertEquals(90, a1);
			assertEquals(80, a2);
		} catch (HangmanException e) {
		}

	}

	@Test
	public void scoreLessThan0OriginalScore() {
		GameScore g = new OriginalScore();
		try {
			int a = g.calculateScore(0, 10);
			int a1 = g.calculateScore(0, 11);
			int a2 = g.calculateScore(0, 9);
			assertEquals(0, a);
			assertEquals(0, a1);
			assertEquals(10, a2);
		} catch (HangmanException e) {
		}

	}

	@Test
	public void scoreGreaterThan0BonusScore() {
		GameScore g = new BonusScore();
		try {
			int a = g.calculateScore(1, 0);
			int a1 = g.calculateScore(5, 9);
			int a2 = g.calculateScore(0, 0);
			assertEquals(10, a);
			assertEquals(5, a1);
			assertEquals(0, a2);
		} catch (HangmanException e) {
		}

	}

	@Test
	public void scoreLessThan0BonusScore() {
		GameScore g = new BonusScore();
		try {
			int a = g.calculateScore(5, 10);
			int a1 = g.calculateScore(5, 11);
			int a2 = g.calculateScore(0, 0);

			assertEquals(0, a);
			assertEquals(0, a1);
			assertEquals(0, a2);
		} catch (HangmanException e) {
		}

	}

	@Test
	public void scoreBetween0And500PowerBonusScore() {
		GameScore g = new PowerScore();
		try {
			int a = g.calculateScore(3, 19);
			int a1 = g.calculateScore(3, 18);
			assertEquals(3, a);
			assertEquals(11, a1);
		} catch (HangmanException e) {
		}
	}

	@Test
	public void maxScore500PowerScore() {
		GameScore g = new PowerScore();
		try {
			int a = g.calculateScore(4, 0);
			int a1 = g.calculateScore(5, 0);
			assertEquals(500, a);
			assertEquals(500, a1);
		} catch (HangmanException e) {
		}
	}

	@Test
	public void scoreLessThan0PowerScore() {
		GameScore g = new PowerScore();
		try {
			int a = g.calculateScore(1, 1);
			int a1 = g.calculateScore(0, 1);
			int a2 = g.calculateScore(0, 0);
			assertEquals(0, a);
			assertEquals(0, a1);
			assertEquals(0, a2);
		} catch (HangmanException e) {
		}

	}
}